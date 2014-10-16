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
      
      while (index > 0 && heapArray[parent].getKey() < heapArray[index].getKey()) {
          heapArray[index] = heapArray[parent];
          index = parent;
          parent = (index - 1) / 2;
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
  }
}
