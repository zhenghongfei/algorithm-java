package alg.art.string.contains;

public class StringContainsForLoop {

	public static void main(String[] args) {
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPO"));
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPOY"));
	}

	// 空间复杂度：O(1)，时间复杂度：O(m*n)
	public static boolean StringContains(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		for (int i = 0; i < ch2.length; i++) {
			int j = 0;
			for (; j < ch1.length; j++) {
				if (ch2[i] == ch1[j]) {
					break;
				}
			}

			if (j == ch1.length) {
				return false;
			}
		}
		return true;
	}
}