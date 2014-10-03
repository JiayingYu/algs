package treesAndGraphs;

public class BSTNode<T extends Comparable<T>> {
	protected T info;
	protected BSTNode left;
	protected BSTNode right;
	
	public BSTNode(T info) {
		this.info = info;
		left = null;
		right = null;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	
	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	public BSTNode getLeft() {
		return left;
	}
	
	public BSTNode getRight() {
		return right;
	}
	
}
