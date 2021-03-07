package alg.interview;

public class BigNumberSum {
	public static void main(String[] args) {
		System.out.println("100".equals(sum("99", "1")));
		System.out.println("12579".equals(sum("12345", "234")));
		System.out.println("12409".equals(sum("12345", "64")));
		System.out.println("1012344".equals(sum("12345", "999999")));
	}

	static String sum(String str1, String str2) {
		if (str1 == null && str2 != null) {
			return str2;
		}
		if (str1 != null && str2 == null) {
			return str1;
		}
		if (str1 == null && str2 == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		char[] shortCh = ch1.length > ch2.length ? ch2 : ch1;
		char[] longCh = ch1.length > ch2.length ? ch1 : ch2;

		boolean isOver = false;

		int shortLen = shortCh.length - 1;
		int longLen = longCh.length - 1;
		while (shortLen >= 0 && longLen >= 0) {
			int sum = shortCh[shortLen] - '0' + longCh[longLen] - '0';
			if (isOver) {
				sum++;
			}
			if (sum >= 10) {
				result.insert(0, sum - 10);
				isOver = true;
			} else {
				result.insert(0, sum);
				isOver = false;
			}

			shortLen--;
			longLen--;
		}

		while (longLen >= 0) {
			int sum = longCh[longLen] - '0';
			if (isOver) {
				sum++;
			}
			if (sum >= 10) {
				result.insert(0, sum - 10);
				isOver = true;
			} else {
				result.insert(0, sum);
				isOver = false;
			}
			longLen--;
		}

		if (isOver) {
			result.insert(0, 1);
		}
		return result.toString();
	}
}
