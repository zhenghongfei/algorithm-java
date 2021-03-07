package alg.art.string.permutation;
import java.util.Arrays;

public class NextPermutation {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextPermutation(new int[] { 1, 2, 7, 4, 3, 1 })));
	}

	static int[] nextPermutation(int[] nums) {
		int i;
		for (i = nums.length - 2; i >= 0 && nums[i] >= nums[i + 1]; i--) {

		}

		if (i < 0) {
			return nums;
		}

		int j;
		for (j = nums.length - 1; j > i && nums[j] <= nums[i]; j--) {

		}

		swap(nums, i, j);
		reserve(nums, i + 1, nums.length - 1);
		return nums;
	}

	private static void reserve(int[] nums, int from, int to) {
		while (from < to) {
			swap(nums, from, to);
			from++;
			to--;
		}
	}

	static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
