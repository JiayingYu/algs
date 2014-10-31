package dijkstra;

public class Graph {
	private final int MAXVERT = 20;
	private final int INFINITY = Integer.MAX_VALUE;
	private Vertex[] vertList;
	private int[][] adjMat;
	private int nVerts;
	private int nTree;
	private DistParent[] shstPath;
//	private int startToCurrent;
	
	public Graph() {
		vertList = new Vertex[MAXVERT];
		adjMat = new int[MAXVERT][MAXVERT];
		for (int j = 0; j < MAXVERT; j++) {
			for (int k = 0; k < MAXVERT; k++) {
				adjMat[j][k] = INFINITY; // not connected, indicated by -1
			}
		}
		nVerts = 0;
		nTree = 0;
		shstPath = new DistParent[MAXVERT];
	}
	
	public void addVert(String label) {
		
		vertList[nVerts] = new Vertex(label);
		nVerts++;
	}
	
	//directed graph
	public void addEdge(int start, int end, int dist) {
		adjMat[start][end] = dist;
	}
	
	public void shortestPath(int start) {
		int startTree = 0;
		vertList[startTree].isInTree = true;
		nTree = 1;
		for(int j = 0; j < nVerts; j++) {
			int tempDist = adjMat[startTree][j];
			shstPath[j] = new DistParent(startTree, tempDist);
		}
		
		int curVert;
		while(nTree < nVerts) {
			curVert = getMin(); //find the next vertex with minDist to start
			if (curVert == -1) {
				System.out.println("There are unreachable vertices");
				break;
			}
			//put current vert in tree
			vertList[curVert].isInTree = true;
			nTree++;
			updateShstPath(curVert);
			
		}
		displayPaths();
		clearTree();
	}
	
	private int getMin() {
		int minDist = INFINITY;
		int minVertDex = -1; //index of the vertex with minDist
		for (int i = 0; i < nVerts; i++) {
			if (vertList[i].isInTree)
				continue;
			else if (shstPath[i].distance < minDist) {
				minDist = shstPath[i].distance;
				minVertDex = i;
			}
		}
		return minVertDex;
	}
	
	private void updateShstPath(int curVert) {
		for (int j = 0; j < nVerts; j++) {
			if (vertList[j].isInTree || adjMat[curVert][j] == INFINITY) continue;
			int curToJ = adjMat[curVert][j];
			int newDistToJ = curToJ + shstPath[curVert].distance;
			if (newDistToJ < shstPath[j].distance) {
				shstPath[j].distance = newDistToJ;
				shstPath[j].parentVert = curVert;
			}
		}
	}
	
	private void clearTree() {
		for (int i = 0; i < nVerts; i++) {
			vertList[i].isInTree = false;
		}
	}
	
	private void displayPaths() {
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < nVerts; i++) {
			output = output.append(vertList[i].label).append("=");
			if (shstPath[i].distance == INFINITY) {
				output.append("inf");
			}else {
				output.append(shstPath[i].distance);
			}
			int parVert = shstPath[i].parentVert;
			output.append("(" + vertList[parVert].label + ")  ");
		}
		System.out.print(output + "\n");
	}
	
	
}
