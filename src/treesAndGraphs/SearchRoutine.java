package treesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;

public class SearchRoutine {
	public static boolean searchRoutine(Vertex start, Vertex end, 
				DirectedGraph graph) {
		LinkedList<Vertex> q = new LinkedList<Vertex>();
		
		if (start == null) {
			return false;
		}
		start.isVisited = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			Vertex curVert = q.poll();
			LinkedList<Vertex> curAdjList = graph.getAdjList(curVert);
			Iterator<Vertex> iterator = curAdjList.iterator();
			while (iterator.hasNext()) {
				Vertex nextAdjV = iterator.next();
				if (!nextAdjV.isVisited) {
					if (nextAdjV == end) return true;
					nextAdjV.isVisited = true;
					q.add(nextAdjV);
				}
			}
		}
		graph.clear();
		return false;		
	}
	
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(20);
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		Vertex v3 = new Vertex();
		Vertex v4 = new Vertex();
		Vertex v5 = new Vertex();
		Vertex v6 = new Vertex();
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
//		graph.addEdge(v2, v4);
//		graph.addEdge(v3, v5);
		graph.addEdge(v4, v6);
		graph.addEdge(v5, v6);
		System.out.println(searchRoutine(v1, v6, graph));
	}
}
