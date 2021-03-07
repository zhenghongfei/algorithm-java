package alg.art.string.palindrome;

/**
 * 最长回文子串 题目描述 给定一个字符串，求它的最长回文子串的长度。
 * 
 * 分析与解法 最容易想到的办法是枚举所有的子串，分别判断其是否为回文。
 * 这个思路初看起来是正确的，但却做了很多无用功，如果一个长的子串包含另一个短一些的子串，那么对子串的回文判断其实是不需要的。
 */
public class LongestPalindromeForLoop {
	public static void main(String[] args) {
		System.out.println(logestPalindrome("aabcdcbad"));
		System.out.println(logestPalindrome("aaabcddcbd"));
		System.out.println(logestPalindrome("a"));
		System.out.println(logestPalindrome("aba"));
		System.out.println(logestPalindrome("abba"));
	}

	public static String logestPalindrome(String str) {
		if (str == null || str.trim().length() == 0) {
			return "";
		}

		String result = "";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				String subStr = str.substring(i, j + 1);
				if (PalindromeFromMiddle.isPalindrome(subStr)) {
					if (subStr.length() > result.length()) {
						result = subStr;
					}
				}
			}
		}
		return result;
	}
}