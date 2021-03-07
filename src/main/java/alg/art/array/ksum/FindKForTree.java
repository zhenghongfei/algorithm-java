package alg.art.array.ksum;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在二元树中找出和为某一值的所有路径 输入一个整数和一棵二元树，从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条路径，然后打印出和与输入整数相等的所有路径。 例如输入整数22和如下二元树
 *     10  
 *   /    \   
 *  5     12   
 * / \     
 *4   7
 *则打印出两条路径：10, 12和10, 5, 7
 */
public class FindKForTree {
	public static void main(String[] args) {
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node5 = new TreeNode(7, null, null);
		TreeNode node2 = new TreeNode(5, node4, node5);
		TreeNode node3 = new TreeNode(12, null, null);
		TreeNode node1 = new TreeNode(10, node2, node3);
		new FindKForTree().sumOfKNumber(node1, 22);
	}

	List<Integer> treeNodeValueList = new ArrayList<>();

	private void sumOfKNumber(TreeNode treeNode, int sum) {
		if (treeNode == null || treeNode.val > sum) {
			return;
		}

		treeNodeValueList.add(treeNode.val);

		if (treeNode.left == null && treeNode.right == null) {
			if (treeNode.val == sum) {
				System.out.println(treeNodeValueList);
			}
		} else {
			if (treeNode.left != null) {
				sumOfKNumber(treeNode.left, sum - treeNode.val);
			}
			if (treeNode.right != null) {
				sumOfKNumber(treeNode.right, sum - treeNode.val);
			}
		}

		treeNodeValueList.remove(treeNodeValueList.size() - 1);
	}
}