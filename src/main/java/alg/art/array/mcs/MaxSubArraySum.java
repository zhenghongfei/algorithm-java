package alg.art.array.mcs;

/**
 * 最大连续子数组和 题目描述 输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。
 * 求所有子数组的和的最大值，要求时间复杂度为O(n)。
 * 
 * 例如输入的数组为1, -2, 3, 10, -4, 7, 2, -5，和最大的子数组为3, 10, -4, 7, 2， 因此输出为该子数组的和18。
 *
 */
public class MaxSubArraySum {
	public static void main(String[] args) {
		new MaxSubArraySum().maxSumSubArray(new int[] { 1, -2, 3, 10, -4, 7, 2, -5 });
	}

	private void maxSumSubArray(int[] datas) {
		int max = datas[0];
		int currMax = 0;
		for (int i = 0; i < datas.length; i++) {
			if (currMax < 0) {
				currMax = datas[i];
			} else {
				currMax = currMax + datas[i];
			}
			if (currMax > max) {
				max = currMax;
			}
		}
		System.out.println(max);
	}

	/**
	 * 最长连续子数组的和
	 */
	static void MaxSumSubArray() {
		int[] datas = { 1, -2, 3, 10, -4, 7, 2, -5 };
		int max = datas[0];
		int currMax = 0;
		for (int i = 0; i < datas.length; i++) {
			currMax = Math.max(currMax + datas[i], datas[i]);
			max = Math.max(currMax, max);
		}
		System.out.println(max);
	}
}
