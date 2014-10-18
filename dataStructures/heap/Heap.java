package heap;

public class Heap{
	private Node[] heapArray;
	private int maxSize;
	private int curSize;
	
	public Heap(int maxSize) {
		this.maxSize = maxSize;
		curSize = 0;
		heapArray = new Node[maxSize];
	}
	
	public boolean isEmpty() {
		return curSize == 0;
	}
	
  public boolean insert(int key) {
      if (curSize == maxSize)
          return false;
      
      Node newNode = new Node(key);
      heapArray[curSize] = newNode;
      trickleUp(curSize);
      curSize++;
      return true;
  }
  
  private void trickleUp(int index) {
      Node bottom = heapArray[index];
      int parent = (index - 1) / 2;
      
      while (index > 0 && 
      			heapArray[parent].getKey() < bottom.getKey()) {
          heapArray[index] = heapArray[parent];
          index = parent;
          parent = (parent - 1) / 2;
      }
      
      heapArray[index] = bottom;
  }
  
  public Node remove() {
  	Node root = heapArray[0];
  	heapArray[0] = heapArray[curSize - 1];
  	curSize--;
  	trickleDown(0);
  	return root;
  }
  
  private void trickleDown(int index) {
  	Node top = heapArray[index];
  	int largerChild;
  	
  	while(index < curSize / 2) { //while node has at least one child
  		int leftChild = index * 2 + 1;
  		int rightChild = index * 2 + 2;
  		if (rightChild < curSize && 
  				heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
  			largerChild = rightChild;
  		} else {
  			largerChild = leftChild;
  		}
  		
  		if (top.getKey() >= heapArray[largerChild].getKey())
  			break;
  		
  		heapArray[index] = heapArray[largerChild];
  		index = largerChild;
  	}
  	heapArray[index] = top;
  }
  
  public boolean change(int index, int newValue) {
		if (index < 0 || index >= curSize)
			return false;
		
		int oldValue = heapArray[index].getKey();
		heapArray[index].setKey(newValue);
		
		if (oldValue <= newValue)
			trickleUp(index);
		else
			trickleDown(index);
		return true;
	}
  
  public void displayHeap() {
  	System.out.print("heapArray: ");
  	for (int m = 0; m < curSize; m++) {
  		if (heapArray[m] != null) 
  			System.out.print(heapArray[m].getKey() + " ");
  		else
  			System.out.println("--");
  	}
  	System.out.println();
  	
//  	int nBlanks = 32;
//  	int itemsPerRow = 1;
//  	int column = 0;
//  	int j = 0;
//  	String dots = "..................................";
//  	System.out.println(dots+dots);
//  	
//  	while(curSize > 0) {
//  		if (column == 0) {
//  			for (int k = 0; k < nBlanks; k++)
//  				System.out.print(" ");
//  		}
//  		System.out.print(heapArray[j].getKey());
//  		if(++j == curSize)
//  			break;
//  		
//  		if(++column == itemsPerRow) {
//  			nBlanks /= 2;
//  			itemsPerRow *= 2;
//  			column = 0;
//  			System.out.println();
//  		} else {
//  			for (int k = 0; k < nBlanks * 2 - 2; k++) 
//  				System.out.print(" ");
//  		}
//  		System.out.println("\n" + dots + dots);
//  	}
  }
}
