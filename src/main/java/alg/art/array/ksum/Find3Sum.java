package alg.art.array.ksum;

/**
 * 3sum 给定一个整数数组，判断能否从中找出3个数a、b、c，使得他们的和为0，如果能，请找出所有满足和为0个3个数对
 */
public class Find3Sum {
	public static void main(String[] args) {
		new Find3Sum().find3Sum(new int[] { 1, 4, 3, 10, 8, 15 }, 21);
	}

	public void find3Sum(int[] arrs, int sum) {
		quickSort(arrs, 0, arrs.length - 1);
		for (int i = 0; i < arrs.length; i++) {
			find2Sum(arrs, i, sum);
		}
	}

	private void find2Sum(int[] arrs, int i, int sum) {
		int subSum = sum - arrs[i];
		int low = i + 1;
		int high = arrs.length - 1;
		while (low < high) {
			int temp = arrs[low] + arrs[high];
			if (temp == subSum) {
				System.out.println(arrs[i] + "+" + arrs[low] + "+" + arrs[high] + "=" + sum);
				break;
			} else {
				if (temp > sum) {
					high--;
				} else {
					low++;
				}
			}
		}
	}

	private void quickSort(int[] arrs, int low, int high) {
		if (low < high) {
			int pos = partition(arrs, low, high);
			quickSort(arrs, low, pos - 1);
			quickSort(arrs, pos + 1, high);
		}
	}

	private int partition(int[] arrs, int low, int high) {
		int base = arrs[low];
		while (low < high) {
			while (low < high && arrs[high] > base) {
				high--;
			}
			if (low < high) {
				arrs[low++] = arrs[high];
			}
			while (low < high && arrs[low] <= base) {
				low++;
			}
			if (low < high) {
				arrs[high--] = arrs[low];
			}
		}
		arrs[low] = base;
		return low;
	}
}