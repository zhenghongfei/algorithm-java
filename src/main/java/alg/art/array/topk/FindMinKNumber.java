package alg.art.array.topk;

import java.util.Arrays;

/**
 * 寻找最小的k个数 题目描述 输入n个整数，输出其中最小的k个。
 * 利用快排的思想，寻找第k个位置上正确的数，k位置前面的数即是比k位置小的数组，k后面的数即是比k位置元素大的数组
 */
public class FindMinKNumber {

	public static void main(String[] args) {
		new FindMinKNumber().findMinKNumber(new int[] { 3, 2, 5, 1, 4, 9, 7, 8 }, 4);
	}

	private void findMinKNumber(int[] datas, int k) {
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
			while (low < high && datas[high] > base)
				high--;
			if (low < high)
				datas[low++] = datas[high];
			while (low < high && datas[low] <= base)
				low++;
			if (low < high)
				datas[high--] = datas[low];
		}
		datas[low] = base;
		return low;
	}
}