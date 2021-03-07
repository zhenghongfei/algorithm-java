package alg.interview;

public class MaxProfitII {
	public static void main(String[] args) {
		int profit = new MaxProfitII().maxProfit(new int[] { 3, 2, 3, 1, 4, 5 });
		System.out.println(profit == 5);
	}

	public int maxProfit(int[] input) {
		if (input == null || input.length == 0) {
			return 0;
		}

		int max = 0;
		for (int i = 1; i <= input.length - 1; i++) {
			int profit = input[i] - input[i - 1];
			if (profit > 0) {
				max += profit;
			}
		}
		return max;
	}
}