package alg.sort;

/**
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
 * 该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 */
public class MergeSort extends AbstractSort {
	@Override
	protected void sort(int[] datas) {
		int[] temp = new int[datas.length];
		sort(datas, 0, datas.length - 1, temp);
	}

	private static void sort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(arr, left, mid, temp);
			sort(arr, mid + 1, right, temp);
			merge(arr, left, mid, right, temp);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid) {
			temp[t++] = arr[i++];
		}
		while (j <= right) {
			temp[t++] = arr[j++];
		}
		t = 0;
		while (left <= right) {
			arr[left++] = temp[t++];
		}
	}
}