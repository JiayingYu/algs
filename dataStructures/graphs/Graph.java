package graphs;

import java.util.Stack;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVerts; //current number of vertices
	private Stack<Integer> stack; //for depth first search
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++)
			adjMat[i][j] = 0;
		}
	}
	
	public void addVertex(char label) {
		vertexList[nVerts] = new Vertex(label);
		++nVerts;
	}
	
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}
	
	public void dfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(0);
		
		while(!stack.isEmpty()) {
			int v = getAdjUnvisitedVertex(stack.peek());
			if (v == -1) { // if not exists a adjacent vertex, pop the current vertex
				stack.pop();
			} else {
				vertexList[v].wasVisited = true;
				stack.push(v);
				displayVertex(v);
			}
		}
		
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;
		}
	}
	
	private int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++) {
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
				return j; //if found, return the index of the adjacent vertex
			}
		}
		return -1;
	}
}
