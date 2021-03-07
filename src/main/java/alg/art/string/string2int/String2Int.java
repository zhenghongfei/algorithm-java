package alg.art.string.string2int;

/**
 * 输入一个由数字组成的字符串，把它转换成整数并输出。例如：输入字符串"123"，输出整数123。 给定函数原型int StrToInt(const char
 * *str) ，实现字符串转换成整数的功能，不能使用库函数atoi
 */
public class String2Int {
	public static void main(String[] args) {
		System.out.println(str2int(null));
		System.out.println(str2int(""));
		System.out.println(str2int("  "));
		System.out.println(str2int(" %%^ "));
		System.out.println(str2int("+"));
		System.out.println(str2int("-"));
		System.out.println(str2int("+90"));
		System.out.println(str2int("-90"));
		System.out.println(str2int("-a90"));
		System.out.println(str2int("9 0"));
		System.out.println(str2int("-9%0"));
		System.out.println(str2int("-2147483648"));
		System.out.println(str2int("+2147483647"));
		System.out.println(str2int("-2147483649"));
		System.out.println(str2int("+2147483648"));
	}

	static int str2int(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		int n = 0;
		int sign = 1;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '-') {
				sign = -1;
				continue;
			}
			if (ch == '+') {
				continue;
			}
			if (Character.isDigit(ch)) {
				int c = (ch - '0');

				if (sign == 1 && (n > Integer.MAX_VALUE / 10
						|| (n == Integer.MAX_VALUE / 10 && c > Integer.MAX_VALUE % 10))) {
					return Integer.MAX_VALUE;
				}
				if (sign == -1 && (n > Integer.MAX_VALUE / 10
						|| n == Integer.MAX_VALUE / 10 && c > (Integer.MAX_VALUE % 10 + 1))) {
					return Integer.MIN_VALUE;
				}
				n = n * 10 + c;
			}
		}
		return sign == 1 ? n : -n;
	}
}
