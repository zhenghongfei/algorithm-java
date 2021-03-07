package alg.art.string.permutation;

/**
 * 排列
 */
public class StringPermutation {

	/**
	 * 全排序递归实现
	 * 
	 * @param s
	 * @param pos
	 * @param n
	 */
	public static void permutation(char[] s, int pos, int n) {
		if (pos == n) {
			System.out.println(s);
		} else {
			for (int i = pos; i <= n; i++) {
				if (isRepeat(s, pos, i)) {
					continue;
				}
				swap(s, pos, i);
				permutation(s, pos + 1, n);
				swap(s, pos, i);
			}
		}
	}

	private static boolean isRepeat(char[] s, int pos, int i) {
		for (int j = pos; j < i; j++) {
			if (s[j] == s[i]) {
				return true;
			}
		}
		return false;
	}

	public static void swap(char[] s, int i, int j) {
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}

	public static void main(String[] args) {
		String str = "abc";
		permutation(str.toCharArray(), 0, str.length() - 1);

		String str1 = "1222";
		permutation(str1.toCharArray(), 0, str1.length() - 1);
	}
}