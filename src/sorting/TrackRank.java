package sorting;

public class TrackRank {
	private static TreeNode root = null;
	
	public static void track(int d) {
		if (root == null) root = new TreeNode(d);
		else root.insert(d);
	}
	
	public static int getRank(int d) {
		return root.getRank(d);
	}
	
	public static void main(String[] args) {
		track(20);
		track(15);
		track(10);
		track(5);
		track(13);
		track(25);
		track(23);
		track(24);
		System.out.println(getRank(24));
	}
}

class TreeNode {
	int leftSize = 0;
	TreeNode left, right;
	int data;
	
	public TreeNode(int d) {
		data = d;
	}
	
	void insert(int d) {
		if (d <= data) {
			if (left == null) left = new TreeNode(d);
			else left.insert(d);
			leftSize++;
		} else {
			if (right == null) right = new TreeNode(d);
			else right.insert(d);
		}			
	}
	
	//return the number of values equal or smaller than d
	int getRank(int d) {
		if (d == data) {
			return leftSize;
		}	else if (d < data) {
			if (left == null) return -1; //not found
			else return left.getRank(d);
		} else {
			if (right == null) return -1;
			int rightRank = right.getRank(d);
			if (rightRank == -1) return -1;
			else return leftSize + 1 + rightRank;
		}
	}
}
