package alg.art.array.mcs;

/**
 * Problem ：
 * 
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 * 
 * Solution： 思路：动态规划问题。与另一道题目“求连续子数组的最大和”不同的是，乘法满足“负负得正”这一规律，因此，假定f(i)为以数组array[
 * ]的元素array[ i ]结尾的最大乘积，则f( i )不仅与其前一个状态下的最大乘积f( i -
 * 1)有关，还可能与数组中的其他元素有关。如[-2,3,-2,4]，其最大的输出应该是48，即-2 * 3 * -2 * 4。根据观察，我们不仅需要记录下第
 * i - 1 个状态下的连续子数组的最大乘积last_max( 大多数情况下为正 )，还需要记录下第 i -
 * 1个状态下的连续子数组的最小乘积last_min，从而得出第 i 个状态的连续子序列的最大乘积为
 * 
 * cur_max = max( max( last_max * array[ i ], last_min * array[ i ] ) , array[ i
 * ] );
 * 
 * 其中，cur_max相当于第 i 个状态下的f( i ), last_max相当于第 i - 1个状态下的f( i - 1).
 */
public class MaxSubProduct {
	public static void main(String[] args) {
		new MaxSubProduct().maxSumSubArray(new int[] { 1, -2, 3, 10, -4, 7, 2, -5 });
	}

	private void maxSumSubArray(int[] datas) {
		long max = datas[0];
		long lastMax = datas[0];
		long lastMin = datas[0];
		long currMax = datas[0];
		long currMin = datas[0];
		for (int i = 1; i < datas.length; i++) {
			currMax = Math.max(datas[i], Math.max(lastMax * datas[i], lastMin * datas[i]));
			currMin = Math.min(datas[i], Math.min(lastMax * datas[i], lastMin * datas[i]));
			max = Math.max(currMax, max);
			lastMax = currMax;
			lastMin = currMin;
		}
		System.out.println(max);
	}
}