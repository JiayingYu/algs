package stackAndQueue;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}
	
	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}
	
	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.print(stack.min());
	}
}


class NodeWithMin {
	int value;
	int min;
	
	public NodeWithMin(int value, int min) {
		this.value = value;
		this.min = min;
	}
}