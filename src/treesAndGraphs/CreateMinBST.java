package treesAndGraphs;

public class CreateMinBST {
	public static TreeNode createMinBST(int[] a, int start, int end) {
		if (end > start) return null;
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(a[mid]);
		n.left = createMinBST(a, start, mid - 1);
		n.right = createMinBST(a, mid + 1, end);
		return n;
	}
	
	TreeNode createMinBST(int[] a) {
		return createMinBST(a, 0, a.length - 1);
	}
}
