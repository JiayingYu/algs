package linkedList;

//It's not a good approach compared to the stack approach
public class LinkedListPalindromeRecurse {
	public static boolean isPalindrome(LinkedListNode head) {
		Result p = isPalindromeRecurse(head, length(head));
		return p.result;
	}
	
	private static Result isPalindromeRecurse(LinkedListNode head, int len) {
		if (head == null || len == 0) {
			return new Result(null, true);
		} else if (len == 1) {
			return new Result(head.next, true);
		} else if (len == 2) {
			return new Result(head.next.next, head.data == head.next.data);
		}
		
		Result s = isPalindromeRecurse(head.next, len - 2);
		
		if (!s.result || s.node == null) {
			return s;
		} else {
			s.result = head.data == s.node.data;
			s.node = s.node.next;
		}
		return s;
	}
	
	
	private static int length(LinkedListNode l) {
		int len = 0;
		while(l != null) {
			len += 1;
			l = l.next;
		}
		return len;
	}
}

class Result {
	LinkedListNode node;
	boolean result;
	
	Result(LinkedListNode node, boolean result) {
		this.node = node;
		this.result = result;
	}
}
