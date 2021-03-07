package alg.art.array.ksum;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找和为定值的任意多个数 寻找和为定值的多个数 题目描述 输入两个整数n和sum，从数列1，2，3.......n
 * 中随意取几个数，使其和等于sum，要求将其中所有的可能组合列出来。
 * 
 * 分析与解法 解法一 注意到取n，和不取n个区别即可，考虑是否取第n个数的策略，可以转化为一个只和前n-1个数相关的问题。
 * 
 * 如果取第n个数，那么问题就转化为“取前n-1个数使得它们的和为sum-n”，对应的代码语句就是sumOfkNumber(sum - n, n - 1)；
 * 如果不取第n个数，那么问题就转化为“取前n-1个数使得他们的和为sum”，对应的代码语句为sumOfkNumber(sum, n - 1)。
 */
public class FindKSum {
	public static void main(String[] args) {
		new FindKSum().findKSum(25, 10);
	}

	List<Integer> list = new ArrayList<>();

	public void findKSum(int sum, int n) {
		if (sum <= 0 || n <= 0) {
			return;
		}

		if (sum == n) {
			// 输出时，该元素还未加入数组
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println(n + " ");
		}

		// 取第n个值
		list.add(n);
		findKSum(sum - n, n - 1);

		list.remove(list.size() - 1);

		// 不取第n个值
		findKSum(sum, n - 1);
	}
}