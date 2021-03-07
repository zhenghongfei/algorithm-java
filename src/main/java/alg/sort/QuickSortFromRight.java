package alg.sort;

public class QuickSortFromRight extends AbstractSort {
	@Override
	protected void sort(int[] datas) {
		quickSort(datas, 0, datas.length - 1);
	}

	public void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int base = arr[right];
			int i = left;
			int j = right;
			while (true) {
				while (i < j && arr[i] < base) {
					i++;
				}

				while (i < j && arr[j] >= base) {
					j--;
				}

				if (i < j) {
					swap(arr, i, j);
				} else {
					break;
				}
			}

			if (i <= right) {
				swap(arr, right, i);
			}

			quickSort(arr, 0, i - 1);
			quickSort(arr, i + 1, right);
		}
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