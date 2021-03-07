package alg.art.string.permutation;

import java.util.Arrays;

public class PrevPermutation {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(prevnextPermutation(new int[] { 1, 3, 1, 2, 4, 7 })));
	}

	static int[] prevnextPermutation(int[] nums) {
		int i;
		for (i = nums.length - 1; i > 0 && nums[i] >= nums[i - 1]; i--) {

		}
		reserve(nums, i, nums.length - 1);

		int j;
		for (j = i; j <= nums.length - 1 && nums[i - 1] <= nums[j]; j++) {

		}
		swap(nums, i - 1, j);
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
