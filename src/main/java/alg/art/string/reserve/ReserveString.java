package alg.art.string.reserve;

public class ReserveString {
	public static void main(String[] args) {
		System.out.println(LeftReserveForPoint("Ilovebaofeng", 7));
	}

	static String LeftReserveForPoint2(String str, int m) {
		char[] ch = str.toCharArray();

		int p1 = 0;
		int p2 = m;

		int n = ch.length;
		while (true) {
			swap(ch, p1, p2);
			p1++;
			if (p2 < n - 1) {
				p2++;
			} else {
				break;
			}
		}

		if (n % m > 0) {
			// abcdefg->defabc g->defgbc a->defgca b->defgabc
			int r = m - n % m;
			while (r-- > 0) {
				int i = p1;
				while (i < p2) {
					swap(ch, i, i + 1);
					i++;
				}
			}
		}
		return new String(ch);
	}

	static String LeftReserveForPoint(String str, int m) {
		char[] ch = str.toCharArray();

		int p1 = 0;
		int p2 = m;

		int n = ch.length;
		int k = n - m - n % m;
		while (k-- > 0) {
			swap(ch, p1, p2);
			p1++;
			p2++;
		}

		int r = n % m;
		while (r-- > 0) {
			int i = p2;
			while (i > p1) {
				swap(ch, i - 1, i);
				i--;
			}
			p1++;
			p2++;
		}
		return new String(ch);
	}

	public static void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
}