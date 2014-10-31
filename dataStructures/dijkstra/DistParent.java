package dijkstra;

public class DistParent {
	int distance;
	int parentVert;
	
	public DistParent(int parentVert, int dist) {
		distance = dist;
		this.parentVert = parentVert;
	}
}
