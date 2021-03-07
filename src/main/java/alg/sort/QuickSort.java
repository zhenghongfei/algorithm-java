package alg.sort;

/**
 * 它的基本思想是：
 * 通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 */
public class QuickSort extends AbstractSort {
	@Override
	protected void sort(int[] datas) {
		quickSort(datas, 0, datas.length - 1);
	}

	public void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			calPivot(arr, left, right);
			int pivot = right - 1;
			int i = left;
			int j = right - 1;
			while (true) {
				while (arr[++i] < arr[pivot]) {
				}
				while (j > left && arr[--j] > arr[pivot]) {
				}
				if (i < j) {
					swap(arr, i, j);
				} else {
					break;
				}
			}
			if (i < right) {
				swap(arr, i, right - 1);
			}
			quickSort(arr, left, i - 1);
			quickSort(arr, i + 1, right);
		}
	}

	public void calPivot(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		if (arr[left] > arr[mid]) {
			swap(arr, left, mid);
		}
		if (arr[left] > arr[right]) {
			swap(arr, left, right);
		}
		if (arr[right] < arr[mid]) {
			swap(arr, right, mid);
		}
		swap(arr, right - 1, mid);
	}

	/**
	 * 解决同一个位置的交换导致数据为０
	 */
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}