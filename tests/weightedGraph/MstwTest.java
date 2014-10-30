package weightedGraph;

public class MstwTest {
	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addVertex('F');
		graph.addEdge(0, 1, 6); //AB6
		graph.addEdge(0, 3, 4); //AD4
		graph.addEdge(1, 2, 10); //BC10
		graph.addEdge(1, 3, 7); //BD7
		graph.addEdge(1, 4, 7); //BE7
		graph.addEdge(2, 3, 8); //CD8
		graph.addEdge(2, 4, 5); //CE5
		graph.addEdge(2, 5, 6); //CF6
		graph.addEdge(3, 4, 12); //DE12
		graph.addEdge(4, 5, 7); //EF7
		
		System.out.print("Minimum spanning tree: ");
		graph.mstw();
	}
}
