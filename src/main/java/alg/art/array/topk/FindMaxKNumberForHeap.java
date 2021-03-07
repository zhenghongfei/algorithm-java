package alg.art.array.topk;

import java.util.Arrays;

/**
 * 寻找最大的k个数 题目描述 输入n个整数，输出其中最大的k个。 利用堆排序，构建k长度的小顶推
 */
public class FindMaxKNumberForHeap {

	public static void main(String[] args) {
		new FindMaxKNumberForHeap().findMaxKNumber(new int[] { 3, 2, 5, 1, 4, 9, 7, 8 }, 8);
	}

	private void findMaxKNumber(int[] datas, int k) {
		heapSort(datas, 0, datas.length - 1, k);
		System.out.println(Arrays.toString(datas));
	}

	private void heapSort(int[] datas, int low, int high, int k) {
		// 以k长度构建小顶推，以最后非叶子节点开始
		for (int i = k / 2 - 1; i >= 0; i--) {
			adjustHeap(datas, i, k);
		}

		for (int j = k; j <= high; j++) {
			if (datas[0] < datas[j]) {
				int temp = datas[0];
				datas[0] = datas[j];
				datas[j] = temp;
			}
			adjustHeap(datas, 0, k);
		}
	}

	private void adjustHeap(int[] datas, int i, int length) {
		int base = datas[i];
		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
			if (k + 1 < length && datas[k] > datas[k + 1]) {
				k++;
			}
			if (datas[k] < base) {
				datas[i] = datas[k];
				i = k;
			} else {
				break;
			}
		}
		datas[i] = base;
	}
}