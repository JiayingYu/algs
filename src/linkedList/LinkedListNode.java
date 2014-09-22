package linkedList;

public class LinkedListNode {
	int data;
	LinkedListNode next = null;
	LinkedListNode prev = null;
	
	public LinkedListNode(int data) {
		this.setData(data);
	}
	
	void appendToTail(int d) {
		LinkedListNode end = new LinkedListNode(d);
		LinkedListNode thisList = this;
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
	
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
	
	public LinkedListNode getNext() {
		return next;
	}
	
	public String toString() {
		LinkedListNode n = this;
		StringBuffer s = new StringBuffer();
		while(n != null) {
			s.append(n.data).append(" ");
			n = n.next;
		}
		return s.toString();
	}
	
}
