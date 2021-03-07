package alg.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.TreeNode;

/**
 * <PRE>
 *       1                    
 *     /   \
 *    2     3
 *  /   \
 * 4     6
 *  \    /
 *   5  7
 *       a
 *     /   \
 *    b     c
 *  /   \
 * d     f
 *  \    /
 *   e  g
 * </PRE>
 */
public class TreeSearch {

	/**
	 * 前序遍历，根节点->左子树->右子树
	 * <p>
	 * <li>1245673
	 * <li>abdefgc
	 * 
	 * @param treeNode
	 */
	public void preOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		System.out.print(treeNode.val);
		preOrder(treeNode.left);
		preOrder(treeNode.right);
	}

	/**
	 * 中序遍历，左子树->根节点->右子树
	 * <p>
	 * <li>4527613
	 * <li>debgfac
	 * 
	 * @param treeNode
	 */
	public void inOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		inOrder(treeNode.left);
		System.out.print(treeNode.val);
		inOrder(treeNode.right);
	}

	/**
	 * 后续遍历，左子树->右子树->根节点
	 * <p>
	 * <li>5476231
	 * <li>edgfbca
	 */
	public void postOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		postOrder(treeNode.left);
		postOrder(treeNode.right);
		System.out.print(treeNode.val);
	}

	public void preOrderByDfs(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (stack.size() > 0) {
			TreeNode node = stack.pop();
			System.out.print(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	public void inOrderByDfs(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (stack.size() > 0) {
			while (stack.peek().left != null) {
				stack.push(stack.peek().left);
			}

			while (stack.size() > 0) {
				TreeNode node = stack.pop();
				System.out.print(node.val);
				if (node.right != null) {
					stack.push(node.right);
					break;
				}
			}
		}
	}

	/**
	 * 按层遍历，1234657
	 * @param treeNode
	 */
	public void bfsOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(treeNode);
		while (queue.size() > 0) {
			TreeNode node = queue.remove();
			System.out.print(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		root.left = node2;
		root.right = node3;

		node2.left = node4;
		node2.right = node6;

		node4.right = node5;
		node6.left = node7;

		TreeSearch treeSearch = new TreeSearch();
		treeSearch.preOrder(root);
		System.out.println();
		treeSearch.inOrder(root);
		System.out.println();
		treeSearch.postOrder(root);
		System.out.println();
		treeSearch.bfsOrder(root);
	}
}
