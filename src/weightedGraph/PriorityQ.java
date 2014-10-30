package weightedGraph;

public class PriorityQ{
	private final int SIZE = 20;
	private Edge[] queue;
	private int size;
	
	public PriorityQ() {
		queue = new Edge[SIZE];	
		size = 0;
	}
	
	public void insert(Edge edge) {
		int j;
		for (j=0; j <size; j++) {
			if (edge.distance >= queue[j].distance) break;
			
			for(int k = size-1; k >= j; k--)
				queue[k + 1] = queue[k];
			
			queue[j] = edge;
			size++;
		}
	}
	
	public Edge removeMin() {
		return queue[--size];
	}
	
	public void removeN(int n) {
		for (int j = n; j < size - 1; j++) {
			queue[j] = queue[j + 1];
		}
			size--;
	}
	
	public Edge peekMin() {
		return queue[size - 1];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public Edge peekN(int n) {
		return queue[n];
	}
	
	public int find(int findDex) { //find item with specified destVert value
		for(int j = 0; j < size; j++) {
			if (queue[j].destVert == findDex)
				return j;
		}
		return -1;
	}
}
