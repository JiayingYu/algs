package graphs;

public class Vertex {
	char label;
	boolean wasVisited;
	
	public Vertex(char label) {
		this.label = label;
		wasVisited = false;
	}
}
