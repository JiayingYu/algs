package treesAndGraphs;

public class FindSumPath {
	public static void findSum(TreeNode curNode, int sum, int[] path, int level) {
		if(curNode == null) return;
		
		path[level] = curNode.data;
		
		int sumUp = 0;
		for(int i = level; i >= 0; i--) {
			sumUp += path[i];
			if (sumUp == sum)
				printPath(path, i, level);
		}
		
		findSum(curNode.left, sum, path, level + 1);
		findSum(curNode.right, sum, path, level + 1);
		
		path[level] = Integer.MIN_VALUE;
	}
	
	public static void findSum(TreeNode root, int sum) {
		int depth = depth(root);
		int[] path = new int[depth];
		findSum(root, sum, path, 0);
	}
	
	public static int depth(TreeNode node) {
		if (node == null) return 0;
		return 1 + Math.max(depth(node.left), depth(node.right));
	}
	
	public static void printPath(int[] path, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
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
		
		findSum(n1, 8);
	}
}
