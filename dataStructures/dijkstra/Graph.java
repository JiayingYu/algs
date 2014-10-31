package dijkstra;

import java.util.LinkedList;

public class Graph {
	private final int MAXVERT;
	private Vertex[] vertList;
	private int[][] adjMat;
	private int nVerts;
	
	public Graph(int maxVert) {
		MAXVERT = maxVert;
		vertList = new Vertex[MAXVERT];
		adjMat = new int[MAXVERT][MAXVERT];
		nVerts = 0;
		for (int j = 0; j < MAXVERT; j++) {
			for (int k = 0; k < MAXVERT; k++) {
				adjMat[j][k] = -1; // not connected, indicated by -1
			}
		}
	}
	
	public void addVert(String label) {
		Vertex newVert = new Vertex(label);
		vertList[nVerts] = newVert;
		nVerts++;
	}
	
	public void addEdge(int start, int end, int dist) {
		adjMat[start][end] = dist;
	}
	
	public void shortestPath(int start) {
		LinkedList<Integer> shstPath = new LinkedList<Integer>(); //store the index of the vertices in the path in order
		vertList[start].isInTree = true;
		vertList[start].distToStart = 0;
		shstPath.add(start);
		System.out.print(vertList[start].label + " ");
		
		int curVert = start;
		for (int i = 0; i < nVerts; i++) {
			if (vertList[i].isInTree)
				continue;
			int nextEdge = adjMat[curVert][i];
			if (nextEdge == -1) //not a adjacent vertex with current vertex
				continue;
			int newDist = vertList[curVert].distToStart + nextEdge;
			if (vertList[i].distToStart == -1 || newDist < vertList[i].distToStart) {
				vertList[i].distToStart = newDist;
			}
			
		}
	}
	
	
	
}
