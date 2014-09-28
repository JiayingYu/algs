package stackAndQueue;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {
	Stack<Integer> min;
	
	public StackWithMin2() {
		min = new Stack<Integer>();
	}
	
	public void push(int value) {
		if (value <= min()) {
			min.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min.peek()) {
			min.pop();
		}
		return value;
	}
	
	public int min() {
		if (min.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
		return min.peek();
		}
	}
	
	
	public static void main(String[] args) {
		StackWithMin2 stack = new StackWithMin2();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.print(stack.min());
	}
}
