package alg.sort;

public class QuickSortFromMid extends AbstractSort {
	@Override
	protected void sort(int[] datas) {
		quickSort(datas, 0, datas.length - 1);
	}

	public void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			partition(arr, left, right);
			int pos = right - 1;
			int base = arr[pos];
			int i = left;
			int j = pos;
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

			if (i <= pos) {
				swap(arr, i, pos);
			}
			quickSort(arr, left, i - 1);
			quickSort(arr, i + 1, right);
		}
	}

	private void partition(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		if (arr[left] > arr[mid]) {
			swap(arr, left, mid);
		}
		if (arr[left] > arr[right]) {
			swap(arr, left, right);
		}
		if (arr[mid] > arr[right]) {
			swap(arr, mid, right);
		}
		swap(arr, mid, right - 1);
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