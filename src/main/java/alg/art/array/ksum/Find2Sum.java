package alg.art.array.ksum;

/**
 * 寻找和为定值的两个数 题目描述 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。
 * 要求时间复杂度是O(N)。如果有多对数字的和等于输入的数字，输出任意一对即可。
 * 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 */
public class Find2Sum {
	public static void main(String[] args) {
		new Find2Sum().find2Sum(new int[] { 1, 4, 2, 11, 7, 15 }, 15);
	}

	public void find2Sum(int[] arrs, int sum) {
		quickSort(arrs, 0, arrs.length - 1);
		int i = 0;
		int j = arrs.length - 1;
		while (i < j) {
			int temp = arrs[i] + arrs[j];
			if (temp == sum) {
				System.out.println(arrs[i] + "+" + arrs[j] + "=" + sum);
				break;
			} else {
				if (temp > sum) {
					j--;
				} else {
					i++;
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