package alg.art.array.topk;

import java.util.Arrays;

/**
 * 寻找最大的k个数 题目描述 输入n个整数，输出其中最大的k个。
 */
public class FindMaxKNumber {

	public static void main(String[] args) {
		new FindMaxKNumber().findMaxKNumber(new int[] { 3, 2, 5, 1, 4, 9, 7, 8 }, 4);
	}

	private void findMaxKNumber(int[] datas, int k) {
		int pos = quickSort(datas, 0, datas.length - 1, k);
		System.out.println(pos);
		System.out.println(Arrays.toString(datas));
	}

	private int quickSort(int[] datas, int low, int high, int k) {
		int pos = partition(datas, low, high);
		if (pos == k - 1) {
			return pos;
		} else if (pos > k - 1) {
			return quickSort(datas, low, pos - 1, k);
		} else {
			return quickSort(datas, pos + 1, high, k);
		}
	}

	private int partition(int[] datas, int low, int high) {
		int base = datas[low];
		while (low < high) {
			while (low < high && datas[high] < base)
				high--;
			if (low < high)
				datas[low++] = datas[high];
			while (low < high && datas[low] >= base)
				low++;
			if (low < high)
				datas[high--] = datas[low];
		}
		datas[low] = base;
		return low;
	}
}