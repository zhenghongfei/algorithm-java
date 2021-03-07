package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBuilder {
    public static void main(String[] args) {
        TreeBuilder.buildTree(new Integer[]{1, null, 2, 3});
        TreeBuilder.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        TreeBuilder.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
    }

    private static void printTree(TreeNode root) {
        TreePrinter<TreeNode> printer = new TreePrinter<>(n -> "" + n.getValue(), n -> n.getLeft(), n -> n.getRight());
        printer.setHspace(2);
        printer.setSquareBranches(false);
        printer.printTree(root);
    }


    /**
     * 按层构建二叉树（Leetcode示例构建二叉树方法），可以压缩空节点
     *
     * @param input 带构建二叉树的数组
     * @return 返回构建的二叉树
     */
    public static TreeNode buildTree(Integer[] input) {
        if (input.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(input[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for (int i = 1; i < input.length; i++) {
            TreeNode node = q.peek();
            if (node.left == null) {
                node.left = new TreeNode(input[i]);
                if (input[i] != null) {
                    q.add(node.left);
                }
            } else if (node.right == null) {
                node.right = new TreeNode(input[i]);
                if (input[i] != null) {
                    q.add(node.right);
                }

                if (node.left != null && node.left.val == null) {
                    node.left = null;
                }
                if (node.right != null && node.right.val == null) {
                    node.right = null;
                }
                q.remove();
            }
        }
        printTree(root);
        return root;
    }

    public static TreeNode buildBinaryTree(Integer[] input) {
        TreeNode root = buildBinaryTree(input, 0);
        printTree(root);
        return root;
    }


    private static TreeNode buildBinaryTree(Integer[] input, int index) {
        if (index >= input.length) {
            return null;
        }

        Integer value = input[index];
        if (value == null) {
            return null;
        }

        TreeNode treeNode = new TreeNode(value);
        treeNode.left = buildBinaryTree(input, 2 * index + 1);
        treeNode.right = buildBinaryTree(input, 2 * index + 2);
        return treeNode;
    }
}