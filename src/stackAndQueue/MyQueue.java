/* myQueque class which implemented with 2 stacks*/

package stackAndQueue;

import java.util.Stack;

public class MyQueue<T> {
	private Stack<T> stackNewest;
	private Stack<T> stackOldest;

	public MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(T newElem) {
		stackNewest.push(newElem);
	}
	
	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}
	
	public static void main(String[] args) {
		MyQueue<String> q = new MyQueue<String>();
		q.add("a");
		q.add("b");
		q.add("c");
		q.add("d");
		
		while(q.size() > 0) {
			System.out.println(q.remove());
		}
	}
}
