package treesAndGraphs;

public class Balanced {
	public static int checkHeight(TreeNode root) {
		if (root == null)
			return 0;
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1) return -1;
		
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1) return -1;
		
		int heightDiff = leftHeight - rightHeight;
		if (Math.abs(heightDiff) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}
	
	public static boolean isBalanced(TreeNode root) {
		return checkHeight(root) == -1 ? false : true;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		root.left = n1; 
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n3.left = n7;
		n3.right = n8;
		
	  System.out.println(isBalanced(root));
	}
}
