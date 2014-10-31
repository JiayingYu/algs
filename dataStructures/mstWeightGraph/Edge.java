package mstWeightGraph;

class Edge {
	int srcVert; //index of a vertex starting edge
	int destVert; //index of a vertex ending edge
	int distance;
	
	public Edge(int sv, int dv, int d) {
		srcVert = sv;
		destVert = dv;
		distance = d;
	}
}
