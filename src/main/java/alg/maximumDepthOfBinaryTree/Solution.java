package alg.maximumDepthOfBinaryTree;

import alg.binarytree.TreeNode;
import alg.binarytree.TreeNodeGenerator;

public class Solution {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int h = 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (left > right) {
			h = left + 1;
		} else {
			h = right + 1;
		}
		return h;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxDepth(TreeNodeGenerator.generateTreeNode()));
	}
}