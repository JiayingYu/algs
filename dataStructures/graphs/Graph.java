package graphs;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex[] vertexList;
	private int[][] adjMat;
	private int nVerts; //current number of vertices
	private Stack<Integer> stack; //used depth first search
	private LinkedList<Integer> queue = new LinkedList<Integer>(); //used bread first search
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		stack = new Stack<Integer>();
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
		resetVertList();
	}
	
	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.add(0);
		
		while(!queue.isEmpty()) {
			int curVert = queue.poll(); // remove the vertex at head
			
			int adjVert; // next adjacent vertex to the current vertex
			while((adjVert = getAdjUnvisitedVertex(curVert)) != -1) {
				vertexList[adjVert].wasVisited = true;
				queue.add(adjVert);
				displayVertex(adjVert);
			}
		}
		resetVertList();
	}
	
	private int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++) {
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
				return j; //if found, return the index of the adjacent vertex
			}
		}
		return -1;
	}
	
	private void resetVertList() {
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].wasVisited = false;
		}
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A');  // 0
		graph.addVertex('B');  // 1
		graph.addVertex('C');  // 2
		graph.addVertex('D');  // 3
		graph.addVertex('E');  // 4

		graph.addEdge(0, 1); //AB
		graph.addEdge(1, 2); //BC
		graph.addEdge(0, 3); //AD
		graph.addEdge(3, 4); //DE

		//test dfs
		System.out.print("Depth first search: \n");
		graph.dfs();
		System.out.println();
		
		//test bfs
		System.out.print("Breadth first search: \n");
		graph.bfs();
		System.out.println();
	}
	
}
