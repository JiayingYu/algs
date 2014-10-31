package dijkstra;

public class DijkstraTest {
	public static void main(String[] args) {
		GraphDijkstra graph = new GraphDijkstra();
		graph.addVertex("A");  // 0
		graph.addVertex("B");  // 1
		graph.addVertex("C");  // 2
		graph.addVertex("D");  // 3
		graph.addVertex("E");  // 4
		
		graph.addEdge(0, 1, 50); //AB50
		graph.addEdge(0, 3, 80); //AD80
		graph.addEdge(1, 2, 60); //BC60
		graph.addEdge(1, 3, 90); //BD90
		graph.addEdge(2, 4, 40); //CE40
		graph.addEdge(3, 2, 20); //DC20
		graph.addEdge(3, 4, 70); //DE70
		graph.addEdge(4, 1, 50); //EB50
		
		System.out.println("Shortest Paths");
		graph.shortestPath();
	}
}
