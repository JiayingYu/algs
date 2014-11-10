package treesAndGraphs;

public class FindSuccessor {

	public static TreeNodeP inorderSucc(TreeNodeP node) {
		if (node == null) return null;
		
		if (node.parent == null || node.right != null) {
			return leftMostChild(node.right);
		}
		
		TreeNodeP curNode = node;
		TreeNodeP parent = node.parent;
		
		while (parent.left != curNode) {
			curNode = parent;
			parent = curNode.parent;
		}
		return parent;
				
	}
	
	public static TreeNodeP leftMostChild(TreeNodeP node) {
		if (node == null) return null;
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}


class TreeNodeP {
	int data;
	TreeNodeP left;
	TreeNodeP right;
	TreeNodeP parent;
	
	public TreeNodeP(int data) {
		this.data = data;
		left = right = parent = null;
	}
}
