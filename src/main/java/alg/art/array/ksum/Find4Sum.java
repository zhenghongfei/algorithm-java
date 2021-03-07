package alg.art.array.ksum;

/**
 * 4sum 给定一个整数数组，判断能否从中找出4个数a、b、c、d，使得他们的和为0，如果能，请找出所有满足和为0个4个数对
 */
public class Find4Sum {
	int sum = 18;

	public static void main(String[] args) {
		Find4Sum findSum = new Find4Sum();
		findSum.find4Sum(new int[] { 1, 4, 3, 10, 8, 15 }, findSum.sum);
	}

	public void find4Sum(int[] arrs, int sum) {
		quickSort(arrs, 0, arrs.length - 1);
		for (int i = 0; i < arrs.length; i++) {
			find3Sum(arrs, i, sum - arrs[i]);
		}
	}

	public void find3Sum(int[] arrs, int i, int sum) {
		for (int j = i + 1; j < arrs.length; j++) {
			find2Sum(arrs, i, j, sum - arrs[j]);
		}
	}

	private void find2Sum(int[] arrs, int i, int j, int sum) {
		int low = j + 1;
		int high = arrs.length - 1;
		while (low < high) {
			int temp = arrs[low] + arrs[high];
			if (temp == sum) {
				System.out.println(arrs[i] + "+" + arrs[j] + "+" + arrs[low] + "+" + arrs[high] + "=" + this.sum);
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