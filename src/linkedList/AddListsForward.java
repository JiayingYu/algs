package linkedList;

public class AddListsForward {
	public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		int len1 = length(l1);
		int len2 = length(l2);
		
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		} else if(len1 > len2) {
			l2 = padList(l2, len1 - len2);
		}
		
		PartialSum result = addListHelper(l1, l2);
		if (result.carry == 0)
			return result.sum;
		else
			return insertBefore(result.sum, result.carry);
	}
	
	private static PartialSum addListHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			return new PartialSum();
		}
		
		PartialSum prevSum = addListHelper(l1.next, l2.next);
		int curValue = l1.data + l2.data + prevSum.carry;
		int carry = curValue / 10;
		int curDigit = curValue % 10;
		LinkedListNode full_result = insertBefore(prevSum.sum, curDigit);
		
		PartialSum curSum = prevSum;
		curSum.sum = full_result;
		curSum.carry = carry;
		return curSum;
	}
	
	private static LinkedListNode insertBefore(LinkedListNode l, int data) {
		LinkedListNode n = new LinkedListNode(data);
		if (l != null) {
			n.next = l;
			l.prev = n;
		}
		return n;
	}
	
	private static int length(LinkedListNode l) {
		int len = 0;
		while(l != null) {
			len += 1;
			l = l.next;
		}
		return len;
	}
	
	private static LinkedListNode padList(LinkedListNode l, int padding) {
		LinkedListNode head = l;
		for (int i = 0; i < padding; i++) {
			LinkedListNode paddingNode = new LinkedListNode(0);
			paddingNode.next = head;
			head.prev = paddingNode;
			head = paddingNode;
		}
		return head;
	}
	
	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(2);
		n1.appendToTail(9);
		n1.appendToTail(5);
		n1.appendToTail(4);
		
		LinkedListNode n2 = new LinkedListNode(6);
		n2.appendToTail(1);
		n2.appendToTail(7);
		
		System.out.print(addLists(n1, n2));
	}
}

class PartialSum {
	LinkedListNode sum = null;
	int carry = 0;
	}
	
	




