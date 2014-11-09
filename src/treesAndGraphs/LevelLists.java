package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelLists {
	ArrayList<LinkedList<TreeNode>> lists =
			new ArrayList<LinkedList<TreeNode>>();
	
	private void createLevelLists(TreeNode r, int depth) {
		if (r == null) return;
		
		LinkedList<TreeNode> list;
		if (lists.size() - 1 < depth) { //level not contained in lists
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(depth);
		}
		list.add(r);
		createLevelLists(r.left, depth + 1);
		createLevelLists(r.right, depth + 1);
	}
	
	public ArrayList<LinkedList<TreeNode>> createLevelLists(TreeNode root) {
		createLevelLists(root, 0);
		return lists;
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
		
		LevelLists lists = new LevelLists();
		ArrayList<LinkedList<TreeNode>> levelLists = lists.createLevelLists(n1);
		for (LinkedList<TreeNode> list : levelLists) {
			for (TreeNode node : list) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
}
