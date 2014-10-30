package weightedGraph;

public class WeightedGraph {
	private final int MAX_VERTS = 20;
	private final int INFINITY = 100000;
	private Vertex[] vertList;
	private int[][] adjMat;
	private int nVerts;
	private PriorityQ edgePQ;
	
	public WeightedGraph() {
		vertList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = INFINITY;
			}
		}
		edgePQ = new PriorityQ();	
	}
	
	public void addVertex(char label) {
		vertList[nVerts++] = new Vertex(label);
	}
	
	public void addEdge(int start, int end, int weight) {
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertList[v].label);
	}
	
	//minimum spanning tree of weighted graph
	public void mstw() {
		int nInTree = 0; //number of verts in tree
		int currentVert = 0;
		
		//insert edges adjacent to currentVert into PQ
		while(nInTree < nVerts - 1) {
			vertList[currentVert].isInTree = true;
			nInTree++;
			
			for (int end = 0; end < nVerts; end ++) {
				if (end == currentVert)
					continue;
				if (vertList[end].isInTree)
					continue;
				
				int distance = adjMat[currentVert][end];
				if (distance == INFINITY)
					continue;
				
				putInPQ(currentVert, end, distance);
			}
			
			if(edgePQ.size() == 0) {
				System.out.print("Graph not connected");
				return;
			}
			
			Edge nextEdge = edgePQ.removeMin();
			int sourceVert = nextEdge.srcVert;
			currentVert = nextEdge.destVert;
			
			System.out.print(vertList[sourceVert].label);
			System.out.print(vertList[currentVert].label + " ");
		}
		
		for (int i = 0; i < nVerts; i++) {
			vertList[i].isInTree = false;
		}
	}
	
	private void putInPQ(int start, int end, int newDist) {
		int oldEgDexInPQ =  edgePQ.find(end);
		if (oldEgDexInPQ != -1) {
			Edge oldEdge = edgePQ.peekN(oldEgDexInPQ);
			if (oldEdge.distance > newDist) {
				edgePQ.removeN(oldEgDexInPQ);
				Edge newEdge = new Edge(start, end, newDist);
				edgePQ.insert(newEdge);
			}
		} else {
			Edge newEdge = new Edge(start, end, newDist);
			edgePQ.insert(newEdge);
		}
	}
}
