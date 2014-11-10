package treesAndGraphs;

public class LowestCommonAncestor {	
	//return the node of the lowest common ancestor
	public static Result lca(TreeNode root, TreeNode x, TreeNode y) {
		Result result = new Result();
		if (root == null) return result;
		
		Result left = lca(root.left, x, y);
		Result right = lca(root.right, x, y);
		if (left.node != null) return left;
		if (right.node != null) return right;
		
		if (left.foundx || right.foundx || root == x) 
			result.foundx = true;
		if (left.foundy || right.foundy || root == y)
			result.foundy = true;
		
		if (result.foundx && result.foundy)
			result.node = root;
		
		return result;
	}
	
	public static TreeNode firstCommon (TreeNode root, TreeNode x, TreeNode y) {
		return lca(root, x, y).node;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		
		TreeNode lca = firstCommon(n1, n8, n7);
		System.out.println(lca.data);
	}
}

class Result {
	boolean foundx;
	boolean foundy;
	TreeNode node;
}
