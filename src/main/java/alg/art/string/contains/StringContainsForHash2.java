package alg.art.string.contains;

public class StringContainsForHash2 {

	public static void main(String[] args) {
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPO"));
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPOY"));
	}

	// 空间复杂度：O(1)，时间复杂度：O(n+m)
	public static boolean StringContains(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		int hash = 0;
		for (int i = 0; i < ch1.length; i++) {
			hash |= (1 << (ch1[i] - 'A'));
		}

		for (int i = 0; i < ch2.length; i++) {
			if ((hash & (1 << (ch2[i] - 'A'))) == 0) {
				return false;
			}
		}
		return true;
	}
}