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
		
	}
}
