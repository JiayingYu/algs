package stackAndQueue;

public class Node {
	int data;
	Node next = null;
	Node prev = null;
	
	public Node(int data) {
		this.setData(data);
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node thisList = this;
		while(thisList.next != null) {
			thisList = thisList.next;
		}
		thisList.next = end;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}
	
	public String toString() {
		Node n = this;
		StringBuffer s = new StringBuffer();
		while(n != null) {
			s.append(n.data).append(" ");
			n = n.next;
		}
		return s.toString();
	}
	
}
