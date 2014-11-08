package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelLists {
	ArrayList<LinkedList<TreeNode>> lists =
			new ArrayList<LinkedList<TreeNode>>();
	
	private void createLevelLists(TreeNode r, int depth) {
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
}
