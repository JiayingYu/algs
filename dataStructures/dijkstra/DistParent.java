package dijkstra;

public class DistParent {
	int distance;
	int parentVert;
	
	public DistParent(int dist, int parentVert) {
		distance = dist;
		this.parentVert = parentVert;
	}
}
