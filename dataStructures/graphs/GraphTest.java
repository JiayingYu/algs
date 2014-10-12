package graphs;

public class GraphTest {
	public static void main(String[] args) {
		testBfs();
		testDfs();
		testMst();
		testTopSort();
	}
	
	private static void testDfs() {
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

		System.out.print("Depth first search: \n");
		graph.dfs();
		System.out.println();
	}
	
	private static void testBfs() {
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
		
		System.out.print("Breadth first search: \n");
		graph.bfs();
		System.out.println();
	}
	
	//test miminum spanning tree
	private static void testMst() {
		Graph graph = new Graph();
		graph.addVertex('A');  // 0
		graph.addVertex('B');  // 1
		graph.addVertex('C');  // 2
		graph.addVertex('D');  // 3
		graph.addVertex('E');  // 4

		graph.addEdge(0, 1); //AB
		graph.addEdge(0, 2); //AC
		graph.addEdge(0, 3); //AD
		graph.addEdge(0, 4); //AE
		graph.addEdge(1, 2); //BC
		graph.addEdge(1, 3); //BD
		graph.addEdge(1, 4); //BE
		graph.addEdge(2, 3); //CD
		graph.addEdge(2, 4); //CE
		graph.addEdge(3, 4); //DE

		System.out.println("Minimun spanning tree: ");
		graph.minSpanTree();
	}
	
	private static void testTopSort() {
		Graph graph = new Graph();
		graph.addVertex('A');  // 0
		graph.addVertex('B');  // 1
		graph.addVertex('C');  // 2
		graph.addVertex('D');  // 3
		graph.addVertex('E');  // 4
		graph.addVertex('F');  // 5
		graph.addVertex('G');  // 6
		graph.addVertex('H');  // 7
		
		graph.addDirectedEdge(0, 3); //AD
		graph.addDirectedEdge(0, 4); //AE
		graph.addDirectedEdge(1, 4); //BE
		graph.addDirectedEdge(2, 5); //CF
		graph.addDirectedEdge(3, 6); //DG
		graph.addDirectedEdge(4, 6); //EG
		graph.addDirectedEdge(5, 7); //FH
		graph.addDirectedEdge(6, 7); //GH
		
		graph.topSort();
	}
}
