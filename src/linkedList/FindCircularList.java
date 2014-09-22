package linkedList;

public class FindCircularList {
	public static LinkedListNode findBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		 
		//find meeting point. slow and fast pointer will be k nodes before the loop start
		while(slow != null && fast != null) {
			 slow = slow.next;
			 fast = fast.next.next;
			 if (slow == fast) break;
		 }
		 
		//check the case where no meeting point, therefore no loop
		 if(fast == null || fast.next == null) {
			 return null;
		 }
		 
		 slow = head;
		 while(slow != fast) {
			 slow = slow.next;
			 fast = fast.next;
		 }
		 
		 return fast;
	}
	
	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(1);
		LinkedListNode n2 = new LinkedListNode(2);
		LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
		LinkedListNode n5 = new LinkedListNode(5);
		LinkedListNode n6 = new LinkedListNode(6);
		LinkedListNode n7 = new LinkedListNode(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n4;
		
		System.out.print(findBeginning(n1).data);
	}
}
