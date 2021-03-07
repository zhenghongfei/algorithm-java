package alg.art.string.contains;

public class StringContainsForQuickSort {

	public static void main(String[] args) {
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPO"));
		System.out.println(StringContains("EFGHLMNOPQRSABCD", "DCGSRQPOY"));
	}

	// 空间复杂度：O(1)，时间复杂度：O(mlogm)+O(nlogn)+O(m+n)=O(nlongn)
	public static boolean StringContains(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();

		quickSort(ch1, 0, ch1.length - 1);
		quickSort(ch2, 0, ch2.length - 1);

		return compare(ch1, ch2);
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

	public static void quickSort(char[] ch, int low, int high) {
		if (low < high) {
			int pos = high;
			char base = ch[pos];
			int i = low;
			int j = high;
			while (true) {
				while (i < j && ch[i] < base) {
					i++;
				}
				while (i < j && ch[j] >= base) {
					j--;
				}
				if (i < j) {
					swap(ch, i, j);
				} else {
					break;
				}
			}

			if (i <= pos) {
				swap(ch, i, pos);
			}
			quickSort(ch, low, i - 1);
			quickSort(ch, i + 1, pos);
		}
	}

	public static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
}