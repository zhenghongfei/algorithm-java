package alg.sortedArrayToBSTWithMinimalHheight;

public class Solution {
	/**
	 * @param A:
	 *            an integer array
	 * @return: a tree node
	 */
	public TreeNode sortedArrayToBST(int[] arr) {
		if (arr == null) {
			return null;
		}
		int len = arr.length;
		if (len == 0) {
			return null;
		}
		if (len == 1) {
			return new TreeNode(arr[0]);
		}
		return sortedArrayToBST(arr, 0, arr.length - 1);
	}

	private TreeNode sortedArrayToBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = sortedArrayToBST(arr, start, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, end);
		return node;
	}
}