package binarySearchTree;

public interface BSTInterface<T extends Comparable<T>>{
	static final int INORDER = 1;
	static final int PREORDER = 2;
	static final int POSTORDER = 3;
	
	boolean isEmpty();
	//returns true if this BST is empty, otherwise, returns false;
	
	int size();
	
	boolean contains(T element);
	
	boolean remove(T element);
	
	T get(T element);
	//returns an element e from this BST such that e.compareTo(element) == 0
	//if no such element exists, return null.
	
	void add(T element);
	
	int reset(int orderType);
	//initializes current position for a iteration through this BST
	// in orderType order. Returns current number of nodes in the BST.
	
	T getNext(int orderType);
	//preconditions: the BST is not empty
	//		the BST has been reset for orderType
	//		the BST has not been modified since the most recent reset
	//		the end of orderType iteration has not been reached
	//returns the element at the current position on this BST for orderType
	//and advances the value of the current position based on the orderType
}
