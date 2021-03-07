package tree;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer value) {
        this.val = value;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }

    public Integer getValue() {
        return val;
    }

    public void setValue(Integer value) {
        this.val = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    // convenience methods to build trees

    public static TreeNode tree(Integer value, TreeNode left, TreeNode right) {
        return new TreeNode(value, left, right);
    }

    public static TreeNode treeLeft(Integer value, TreeNode left) {
        return new TreeNode(value, left, null);
    }

    public static TreeNode treeRight(Integer value, TreeNode right) {
        return new TreeNode(value, null, right);
    }

    public static TreeNode leaf(Integer value) {
        return new TreeNode(value, null, null);
    }
}

