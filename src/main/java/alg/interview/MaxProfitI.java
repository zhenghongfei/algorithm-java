package alg.interview;

public class MaxProfitI {
	public static void main(String[] args) {
		int profit = new MaxProfitI().maxProfit(new int[] { 3, 2, 3, 1, 4, 5 });
		System.out.println(profit == 4);
	}

	public int maxProfit(int[] input) {
		if (input == null || input.length == 0) {
			return 0;
		}

		int profit = 0;
		int min = input[0];

		for (int i = 1; i <= input.length - 1; i++) {
			profit = Math.max(profit, input[i] - min);
			min = Math.min(min, input[i]);
		}
		return profit;
	}
}