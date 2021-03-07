package alg.art.dp;

public class JumpStairsIteration {

	public static void main(String[] args) {
		int steps = new JumpStairsIteration().jumpStairs(10);
		System.out.println(steps);
	}

	private int jumpStairs(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int a = 1;
		int b = 2;
		int temp = 0;
		for (int i = 3; i <= n; i++) {
			temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
	}
}