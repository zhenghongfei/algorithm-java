package alg.art.array;

import java.util.Arrays;

/**
 * #奇偶调序
 * 
 * 题目描述 输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。要求时间复杂度为O(n)。
 * 
 * 分析与解法
 * 最容易想到的办法是从头扫描这个数组，每碰到一个偶数，拿出这个数字，并把位于这个数字后面的所有数字往前挪动一位。挪完之后在数组的末尾有一个空位，然后把该偶数放入这个空位。由于每碰到一个偶数，需要移动O(n)个数字，所以这种方法总的时间复杂度是O(n^2)，不符合题目要求。
 * 
 * 事实上，若把奇数看做是小的数，偶数看做是大的数，那么按照题目所要求的奇数放在前面偶数放在后面，就相当于小数放在前面大数放在后面，联想到快速排序中的partition过程，不就是通过一个主元把整个数组分成大小两个部分么，小于主元的小数放在前面，大于主元的大数放在后面。
 * 
 * 而partition过程有以下两种实现：
 * 
 * 一头一尾两个指针往中间扫描，如果头指针遇到的数比主元大且尾指针遇到的数比主元小，则交换头尾指针所分别指向的数字；
 * 一前一后两个指针同时从左往右扫，如果前指针遇到的数比主元小，则后指针右移一位，然后交换各自所指向的数字。
 * 类似这个partition过程，奇偶排序问题也可以分别借鉴partition的两种实现解决。
 * 
 * 为何？比如partition的实现一中，如果最终是为了让整个序列元素从小到大排序，那么头指针理应指向的就是小数，而尾指针理应指向的就是大数，故当头指针指的是大数且尾指针指的是小数的时候就不正常，此时就当交换。
 *
 */
public class OldSort {

	public static void main(String[] args) {
		int[] datas = { 2, 4, 1, 6, 5, 7, 9, 8, 0 };

		int i = 0;
		int j = datas.length - 1;
		while (i < j) {
			if (isOldNumber(datas[i])) {
				i++;
			} else if (!isOldNumber(datas[j])) {
				j--;
			} else {
				int temp = datas[i];
				datas[i++] = datas[j];
				datas[j--] = temp;
			}
		}
		System.out.println(Arrays.toString(datas));
	}

	static boolean isOldNumber(int n) {
		return (n & 1) == 1;
	}
}
