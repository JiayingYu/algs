package graphs;

public class GraphTest {
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
		
		//test mst
		testMst();
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
		System.out.println("\n");
	}
}
