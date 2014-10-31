package dijkstra;

public class Vertex {
	String label;
	boolean isInTree;
	
	public Vertex(String label) {
		this.label = label;
		isInTree = false;
	}
}
