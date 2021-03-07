package alg.binarytree;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class TraversalTree {

	void frontTraversal(TreeNode treeNode) {
		if (treeNode != null) {
			System.out.println(treeNode.val);
			frontTraversal(treeNode.left);
			frontTraversal(treeNode.right);
		}
	}

	void midTraversal(TreeNode treeNode) {
		if (treeNode != null) {
			midTraversal(treeNode.left);
			System.out.println(treeNode.val);
			midTraversal(treeNode.right);
		}
	}

	void backTraversal(TreeNode treeNode) {
		if (treeNode != null) {
			backTraversal(treeNode.left);
			backTraversal(treeNode.right);
			System.out.println(treeNode.val);
		}
	}

	void frontTraversalStack(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (treeNode != null || !stack.isEmpty()) {
			if (treeNode != null) {
				stack.push(treeNode);
				System.out.println(treeNode.val);
				treeNode = treeNode.left;
			} else {
				treeNode = stack.pop();
				treeNode = treeNode.right;
			}
		}
	}

	void midTraversalStack(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (treeNode != null || !stack.isEmpty()) {
			if (treeNode != null) {
				stack.push(treeNode);
				treeNode = treeNode.left;
			} else {
				treeNode = stack.pop();
				System.out.println(treeNode.val);
				treeNode = treeNode.right;
			}
		}
	}

	void LevelTraversal(TreeNode treeNode) {
		Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
		queue.add(treeNode);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node.val);

			if (node.left != null) {
				queue.add(node.left);
			}

			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		TraversalTree tt = new TraversalTree();
		TreeNode treeNode = TreeNodeGenerator.generateTreeNode();

		// 前序遍历
		tt.frontTraversal(treeNode);
		System.out.println("===================");
		tt.frontTraversalStack(treeNode);
		System.out.println("===================");

		// 中序遍历
		tt.midTraversal(treeNode);
		System.out.println("===================");
		tt.midTraversalStack(treeNode);
		System.out.println("===================");

		// 后序遍历
		tt.backTraversal(treeNode);
		System.out.println("===================");

		// 分层遍历
		tt.LevelTraversal(treeNode);
	}
}
