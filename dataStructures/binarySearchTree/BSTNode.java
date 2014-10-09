package binarySearchTree;

public class BSTNode<T extends Comparable<T>> {
	protected T info;
	protected BSTNode<T> left;
	protected BSTNode<T> right;
	
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
	
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
	
	public BSTNode<T> getLeft() {
		return left;
	}
	
	public BSTNode<T> getRight() {
		return right;
	}
}
