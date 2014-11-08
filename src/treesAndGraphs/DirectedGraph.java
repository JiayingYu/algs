package treesAndGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class DirectedGraph {
	public final int MAXSIZE;
	ArrayList<Vertex> vertList;
	ArrayList<LinkedList<Vertex>> adjLists;
	
	public DirectedGraph(int maxSize) {
		MAXSIZE = maxSize;
		vertList = new ArrayList<Vertex>(MAXSIZE);
		adjLists = new ArrayList<LinkedList<Vertex>>(MAXSIZE);
	}
	
	public void addVertex(Vertex v) {
		vertList.add(v);
		LinkedList<Vertex> list= new LinkedList<Vertex>();
		list.add(v);
		adjLists.add(list);
	}
	
	public void addEdge(Vertex start, Vertex end) {
		int startDex = vertList.indexOf(start);
		adjLists.get(startDex).add(end);
	}
	
	public int nVerts() {
		return vertList.size();
	}
	
	public LinkedList<Vertex> getAdjList(Vertex v) {
		int indexV = vertList.indexOf(v);
		return adjLists.get(indexV);
	}
	
	public void clear() {
		Iterator<Vertex> it = vertList.iterator();
		while(it.hasNext()) {
			Vertex next = it.next();
			next.isVisited = false;
		}
	}
}
