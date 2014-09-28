package stackAndQueue;

public class SimpleStack {
	Node top;
	
	Node pop() {
		if (top != null) {
			Node item = top;
			top = top.next;
			return item;
		} else 
			return null;			
		}
	
	void push(int item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	
	Object peek() {
		return top.data;
	}
}
