package alg.art.dp;

public class StringEditDistance {

	void editDistance(String A, String B) {
		if (A.equals(B)) {
			System.out.println(0);
			return;
		}
		// dp[i][j]表示源串A位置i到目标串B位置j处最低需要操作的次数
		int[][] dp = new int[A.length() + 1][B.length() + 1];
		for (int i = 1; i <= A.length(); i++)
			dp[i][0] = i;
		for (int j = 1; j <= B.length(); j++)
			dp[0][j] = j;
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
				}
			}
		}
		System.out.println(dp[A.length()][B.length()]);
	}

	public static void main(String[] args) {
		StringEditDistance test = new StringEditDistance();
		String A = "ALGORITHM";
		String B = "ALTRUISTIC";
		test.editDistance(A, B);
	}
}
