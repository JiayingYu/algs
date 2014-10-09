package binarySearchTree;

import queues.LinkedUnbndQueue;

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>{
	protected BSTNode<T> root;
	boolean found; //used by remove
	
	//for traversals
	protected LinkedUnbndQueue<T> inOrderQueue;
	protected LinkedUnbndQueue<T> preOrderQueue;
	protected LinkedUnbndQueue<T> postOrderQueue;
	
	public BinarySearchTree() {
		root = null;
	}

	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	@Override
	public int size() {
		return recSize(root);
	}
	
	private int recSize(BSTNode<T> tree) {
		if (tree == null) {
			return 0;
		}
		
		return recSize(tree.getLeft()) + recSize(tree.getRight()) + 1;
	}

	@Override
	public boolean contains(T element) {
		return recContains(element, root);
	}
	
	private boolean recContains(T element, BSTNode<T> tree) {
		if (tree == null) {
			return false;
		}	else if (element.compareTo(tree.getInfo()) < 0) {
			return recContains(element, tree.getLeft());
		} else if (element.compareTo(tree.getInfo()) > 0) {
			return recContains(element, tree.getRight());
		} else {
			return true;
		}
	}

	@Override
	public boolean remove(T element) { 
		root = recRemove(element, root);
		return found;
	}
	
	//recRemove always return itself;
	private BSTNode<T> recRemove(T element, BSTNode<T> tree) {
		if (tree == null) {
			found = false;
			return null;
		}
		
		if (element.compareTo(tree.getInfo()) < 0) {
			tree.setLeft(recRemove(element, tree.getLeft()));
		} else if (element.compareTo(tree.getInfo()) > 0) {
			tree.setRight(recRemove(element, tree.getRight()));
		} else {
			found = true;
			tree = removeNode(tree);
		}

		return tree; //return itself
	}
	
	private BSTNode<T> removeNode(BSTNode<T> tree) {
		T data;
		if (tree.getLeft() == null) {
			return tree.getRight();
		} else if (tree.getRight() == null) {
			return tree.getLeft();
		} else {
			data = getPredecessor(tree.getLeft());
			tree.setInfo(data);
			tree.setLeft(recRemove(data, tree.getLeft()));
		}
		return tree;
	}
	
	private T getPredecessor(BSTNode<T> tree) {
		while (tree.getRight() != null) {
			tree = tree.getRight();
		}
		return tree.getInfo();
	}

	@Override
	public T get(T element) {
		return recGet(element, root);
	}
	
	private T recGet(T element, BSTNode<T> tree) {
		if (tree == null) {
			return null;
		}	else if (element.compareTo(tree.getInfo()) < 0) {
			return recGet(element, tree.getLeft());
		} else if (element.compareTo(tree.getInfo()) > 0) {
			return recGet(element, tree.getRight());
		} else {
			return tree.getInfo();
		}
	}

	@Override
	public void add(T element) {
		root = recAdd(element, root);
	}
	
	private BSTNode<T> recAdd(T element, BSTNode<T> tree) {
		if (tree == null) {
			tree = new BSTNode<T>(element);
		} else if (element.compareTo(tree.getInfo()) <= 0) {
			tree.setLeft(recAdd(element, tree.getLeft()));
		} else {
			tree.setRight(recAdd(element, tree.getRight()));
		}
		return tree;
	}

	@Override
	public int reset(int orderType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T getNext(int orderType) {
		// TODO Auto-generated method stub
		return null;
	}
}
