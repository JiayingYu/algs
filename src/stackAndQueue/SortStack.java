package stackAndQueue;

import java.util.Stack;

public class SortStack {
	public static Stack<Integer> sort(Stack<Integer> stack1) {
		Stack<Integer> stack2 = new Stack<Integer>();
		while(!stack1.isEmpty()) {
			int tmp = stack1.pop();
			while (!stack2.isEmpty() && stack2.peek() > tmp) {
				stack1.push(stack2.pop());
			}
			stack2.push(tmp);
		}
		return stack2;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(5);
		stack.push(20);
		stack.push(6);
		stack.push(9);
		System.out.println(stack);
		System.out.println(sort(stack));
	}
}
