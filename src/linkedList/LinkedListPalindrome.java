package linkedList;

import java.util.Stack;

public class LinkedListPalindrome {
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;			
		}
		
		//has odd number of elements, skip the middle element
		if (fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			if(slow.data != stack.pop()) return false;
			slow = slow.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(2);
		n1.appendToTail(9);
		n1.appendToTail(5);
		n1.appendToTail(4);
		n1.appendToTail(9);
		System.out.println(isPalindrome(n1));
		
		LinkedListNode n2 = new LinkedListNode(2);
		n2.appendToTail(9);
		n2.appendToTail(5);
		n2.appendToTail(9);
		n2.appendToTail(2);
		System.out.println(isPalindrome(n2));
		
		LinkedListNode n3 = new LinkedListNode(2);
		n3.appendToTail(9);
		n3.appendToTail(5);
		n3.appendToTail(5);
		n3.appendToTail(9);
		n3.appendToTail(2);
		System.out.println(isPalindrome(n3));
	}
	
	
}
