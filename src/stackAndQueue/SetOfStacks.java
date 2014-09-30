package stackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack<Integer>> stackList = new ArrayList<Stack<Integer>>();
  int capcity = 5;
	
	public SetOfStacks(int capacity) {
		this.capcity = capacity;
	}
	
	public void push(int v) {
		Stack<Integer> lastStack = getLastStack();
		if (lastStack != null && !isFull(lastStack.size())) {
			lastStack.push(v);
		} else {
			Stack<Integer> newStack = new Stack<Integer>();
			newStack.push(v);
			stackList.add(newStack);
		}
	}
	
	public int pop() {
		Stack<Integer> lastStack = getLastStack();
		int v = lastStack.pop();
		if (lastStack.size() == 0) {
			stackList.remove(stackList.size() - 1);
		}
		return v;
	}
	
	private Stack<Integer> getLastStack() {
		if (stackList.size() == 0) return null;
		return stackList.get(stackList.size() - 1);
	}
	
	private boolean isFull(int len) {
		return len >= capcity;
	}
	
	public static void main(String[] args) {
		SetOfStacks stackSet = new SetOfStacks(5);
		for (int i = 0; i < 10; i++) {
			stackSet.push(i);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(stackSet.pop());
		}	
	}
	
	public  boolean isEmpty() {
		Stack<Integer> last = getLastStack();
		return last == null || last.isEmpty();
	}
}
