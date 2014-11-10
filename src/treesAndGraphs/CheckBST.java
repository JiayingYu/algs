package treesAndGraphs;

public class CheckBST {
	public static int last = Integer.MIN_VALUE;
	public static boolean checkBST(TreeNode n) {
		if (n == null) return true;
		if (!checkBST(n.left)) return false;
		if (n.data < last) return false;
		last = n.data;
		if (!checkBST(n.right)) return false;
		
		return true;
	}
	
	public static boolean checkBST2 (TreeNode root) {
		return checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean checkBST2(TreeNode n, int min, int max) {
		if (n == null) return true;
		
		if (n.data < min || n.data > max) return false;
		
		if (!checkBST2(n.left, min, n.data)) return false;
		if (!checkBST2(n.right, n.data, max)) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(20);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(30);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(15);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(35);
		TreeNode n8 = new TreeNode(17);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n4.left = n6;
		n4.right = n7;
		n5.right = n8;
		
		System.out.println(checkBST(n1));
		System.out.println(checkBST2(n1));

	}
}
