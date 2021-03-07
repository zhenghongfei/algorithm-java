package alg.art.string.reserve;

/**
 * 字符串反转，3步反转法
 */
public class ReserveStringFor3Step {
	public static void main(String[] args) {
		System.out.println(LeftReserveRotate("Ilovebaofeng", 7));
		System.out.println(RightReserveRotate("Ilovebaofeng", 7));
	}

	// 空间复杂度O(1),时间复杂度O(n)
	static String RightReserveRotate(String str, int m) {
		char[] ch = str.toCharArray();
		int idx = ch.length - m;
		reserve(ch, 0, idx - 1);
		reserve(ch, idx, ch.length - 1);
		reserve(ch, 0, ch.length - 1);
		return new String(ch);
	}

	// 空间复杂度O(1),时间复杂度O(n)
	static String LeftReserveRotate(String str, int m) {
		char[] ch = str.toCharArray();
		reserve(ch, 0, m - 1);
		reserve(ch, m, ch.length - 1);
		reserve(ch, 0, ch.length - 1);
		return new String(ch);
	}

	static void reserve(char[] ch, int i, int j) {
		while (i < j) {
			char temp = ch[i];
			ch[i++] = ch[j];
			ch[j--] = temp;
		}
	}
}