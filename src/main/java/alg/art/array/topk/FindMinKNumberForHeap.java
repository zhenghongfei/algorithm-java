package alg.art.array.topk;

import java.util.Arrays;

/**
 * 寻找最小的k个数 题目描述 输入n个整数，输出其中最小的k个。 利用堆排序，特别适用于海量数据中寻找最大或者最小的k个数字。
 * 即构建一个大堆容器，初始化大小为k，变量初始数，如初始数组大小小于等于k直接返回， 如果大于k，则选择数组的前k个元素，填充堆，然后调整为最大堆。
 * 调整完之后，继续从初始数组中拿出一个元素，如果该元素比大堆的堆顶小，则替换堆顶， 继续调整为最大堆，如果大于等于堆顶则直接丢弃，不作调整。
 */
public class FindMinKNumberForHeap {

	public static void main(String[] args) {
		new FindMinKNumberForHeap().findMinKNumber(new int[] { 3, 2, 5, 1, 4, 9, 7, 8 }, 6);
	}

	private void findMinKNumber(int[] datas, int k) {
		heapSort(datas, 0, datas.length - 1, k);
		System.out.println(Arrays.toString(datas));
	}

	private void heapSort(int[] datas, int low, int high, int k) {
		// 以k长度构建大顶推，以最后非叶子节点开始
		for (int i = k / 2 - 1; i >= 0; i--) {
			adjustHeap(datas, i, k);
		}

		for (int j = k; j <= high; j++) {
			if (datas[0] > datas[j]) {
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
			if (k + 1 < length && datas[k] < datas[k + 1]) {
				k++;
			}
			if (datas[k] > base) {
				datas[i] = datas[k];
				i = k;
			} else {
				break;
			}
		}
		datas[i] = base;
	}
}