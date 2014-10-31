package dijkstra;

public class Vertex {
	String label;
	boolean isInTree;
	int distToStart; // for dijkstra
	
	public Vertex(String label) {
		this.label = label;
		isInTree = false;
		distToStart = -1;
	}
}
