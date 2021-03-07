package alg.art.string.contains;

public class StringContainsForCountSort {

	public static void main(String[] args) {
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPO"));
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPOY"));
	}

	// 空间复杂度：O(27)，时间复杂度：O(n)+O(m)+O(n+m)=O(n+m)
	public static boolean StringContains(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		countSort(ch1);
		countSort(ch2);
		return compare(ch1, ch2);
	}

	private static void countSort(char[] ch) {
		int[] help = new int[26];
		for (int i = 0; i < ch.length; i++) {
			help[ch[i] - 'A']++;
		}

		int index = 0;
		for (int i = 0; i < help.length; i++) {
			while (help[i]-- > 0) {
				ch[index++] = (char) ((char) i + 'A');
			}
		}
	}

	private static boolean compare(char[] ch1, char[] ch2) {
		int pos1 = 0;
		int pos2 = 0;
		while (pos1 < ch1.length && pos2 < ch2.length) {
			while (ch1[pos1] < ch2[pos2] && pos1 < ch1.length - 1) {
				pos1++;
			}
			if (ch1[pos1] != ch2[pos2]) {
				break;
			}
			pos2++;
		}

		return pos2 == ch2.length;
	}
}