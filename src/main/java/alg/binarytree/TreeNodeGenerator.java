package alg.binarytree;

public class TreeNodeGenerator {
	private TreeNodeGenerator() {
	}

	public static TreeNode generateTreeNode() {
		TreeNode tree = new TreeNode("a");

		TreeNode bTree = new TreeNode("b");
		tree.left = bTree;

		tree.right = new TreeNode("c");

		TreeNode dTree = new TreeNode("d");
		bTree.left = dTree;

		dTree.right = new TreeNode("e");

		TreeNode fTree = new TreeNode("f");
		bTree.right = fTree;

		fTree.left = new TreeNode("g");
		return tree;
	}
}
