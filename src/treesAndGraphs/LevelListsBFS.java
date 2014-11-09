package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelListsBFS {

	ArrayList<LinkedList<TreeNode>> createLevelLists(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> curList = new LinkedList<TreeNode>();
		if (root != null) {
			curList.add(root);
		}

		
		while (!curList.isEmpty()) {
			lists.add(curList);
			LinkedList<TreeNode> nextList = new LinkedList<TreeNode>();
			for (TreeNode node: curList) { //iterate through nodes in curList, put all children in nextList
				if (node.left != null)
					nextList.add(node.left);
				if (node.right != null)
					nextList.add(node.right);
			}
			curList = nextList;
		}
		
		return lists;
	}
}
