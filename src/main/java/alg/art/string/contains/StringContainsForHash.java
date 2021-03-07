package alg.art.string.contains;

public class StringContainsForHash {

	public static void main(String[] args) {
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPO"));
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPOY"));
	}

	// 空间复杂度：O(27)，时间复杂度：O(n+m)
	public static boolean StringContains(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		int num = 0;
		int[] hash = new int[26];

		for (int i = 0; i < ch2.length; i++) {
			int index = ch2[i] - 'A';
			if (hash[index] == 0) {
				hash[index]++;
				num++;
			}
		}

		for (int i = 0; i < ch1.length; i++) {
			int index = ch1[i] - 'A';
			if (hash[index] == 1) {
				hash[index] = 0;
				if (num-- == 0) {
					break;
				}
			}
		}

		return num == 0;
	}
}