package alg.art.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 出现次数超过一半的数字 题目描述 题目：数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字。
 * 
 * 分析与解法
 * 一个数组中有很多数，现在我们要找出其中那个出现次数超过总数一半的数字，怎么找呢？大凡当我们碰到某一个杂乱无序的东西时，我们人的内心本质期望是希望把它梳理成有序的。所以，我们得分两种情况来讨论，无序和有序。
 */
public class FindOneNumberFromArray {
	public static void main(String[] args) {
		FindOneNumberFromArray findOneNumberFromArray = new FindOneNumberFromArray();
		findOneNumberFromArray.findOneNumberForHash(new int[] { 1, 3, 9, 8, 4, 6, 3, 3, 5, 3, 3, 3 });
		findOneNumberFromArray.findOneNumberForQuickSort(new int[] { 1, 3, 9, 8, 4, 6, 3, 3, 5, 3, 3, 3 });
		findOneNumberFromArray.findOneNumberForHeapSort(new int[] { 1, 3, 9, 8, 4, 6, 3, 3, 5, 3, 3, 3 });
	}

	// O(n*logn),O(1)
	private void findOneNumberForHeapSort(int[] datas) {
		heapSort(datas);
		System.out.println(datas[(datas.length - 1) >> 2]);
	}

	private void heapSort(int[] datas) {
		// 构建大顶推
		for (int i = (datas.length - 1) / 2; i >= 0; i--) {
			adjustHeap(datas, i, datas.length);
		}
		// 排序，重新构建大顶堆
		for (int i = datas.length - 1; i > 0; i--) {
			// 置换堆顶元素到数组末尾
			int temp = datas[i];
			datas[i] = datas[0];
			datas[0] = temp;
			// 重新对堆进行调整，去除最后一个已经排好序的元素
			adjustHeap(datas, 0, i);
		}
	}

	private void adjustHeap(int[] datas, int i, int length) {
		int temp = datas[i];
		// 获取当前i节点的孩子节点
		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
			// 选择左孩子还是右孩子
			if (k + 1 < length && datas[k] < datas[k + 1]) {
				k++;
			}

			if (datas[k] > temp) {
				datas[i] = datas[k];
				i = k;
			} else {
				break;
			}
		}
		datas[i] = temp;
	}

	// O(n),O(n)
	private void findOneNumberForHash(int[] datas) {
		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < datas.length; i++) {
			Integer data = cache.get(datas[i]);
			if (data == null) {
				cache.put(datas[i], 1);
			} else {
				int count = data.intValue() + 1;
				if (count >= datas.length / 2) {
					System.out.println("The Number is:" + datas[i] + ",count:" + count);
					break;
				}
				cache.put(datas[i], count);
			}
		}
	}

	// O(n*logn),O(1)
	private void findOneNumberForQuickSort(int[] datas) {
		quickSort(datas, 0, datas.length - 1);
		System.out.println(datas[(datas.length - 1) / 2]);
	}

	private void quickSort(int[] datas, int low, int high) {
		if (low < high) {
			int partition = partition(datas, low, high);
			quickSort(datas, low, partition - 1);
			quickSort(datas, partition + 1, high);
		}
	}

	private int partition(int[] datas, int low, int high) {
		int base = datas[low];
		while (low < high) {
			while (low < high && datas[high] > base) {
				high--;
			}
			if (low < high) {
				datas[low++] = datas[high];
			}
			while (low < high && datas[low] <= base) {
				low++;
			}
			if (low < high) {
				datas[high--] = datas[low];
			}
		}
		datas[low] = base;
		return low;
	}
}