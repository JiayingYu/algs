package linkedList;

public class AddLists {

	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(2);
		n1.appendToTail(9);
		n1.appendToTail(5);
		
		LinkedListNode n2 = new LinkedListNode(6);
		n2.appendToTail(1);
		n2.appendToTail(7);
		
		System.out.print(addList(n1, n2));
	}
	
	public static LinkedListNode addList(LinkedListNode l1, LinkedListNode l2) {
		return addList(l1, l2, 0);
	}
	
	private static LinkedListNode addList(LinkedListNode l1, LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}
		
		int newValue = carry;
		if (l1 != null) newValue += l1.getData();
		if (l2 != null) newValue += l2.getData();
		
		LinkedListNode currentDigit = new LinkedListNode(newValue % 10); //store the current digit in the stack for later use
		
		if (l1 != null || l2 != null || newValue >= 10) {
			LinkedListNode nextDigit = addList(l1 == null? null : l1.next, 
					l2 == null? null : l2.next,
					newValue / 10);
			currentDigit.next = nextDigit;
		}
		return currentDigit;
	}
		
}
