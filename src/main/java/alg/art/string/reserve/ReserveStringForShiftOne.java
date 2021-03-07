package alg.art.string.reserve;

/**
 * 字符串反转，移位法
 */
public class ReserveStringForShiftOne {
	public static void main(String[] args) {
		System.out.println(ShiftReserve("Ilovebaofeng", 7));
	}

	// 空间复杂度O(1),时间复杂度O(m*n)
	static String ShiftReserve(String str, int n) {
		char[] ch = str.toCharArray();
		while (n-- > 0) {
			char x = ch[0];
			for (int i = 1; i < ch.length; i++) {
				ch[i - 1] = ch[i];
			}
			ch[ch.length - 1] = x;
		}
		return new String(ch);
	}
}