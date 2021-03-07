package alg.art.string.palindrome;

/**
 * 最长回文子串 题目描述 给定一个字符串，求它的最长回文子串的长度。
 * 
 * 分析与解法 最容易想到的办法是枚举所有的子串，分别判断其是否为回文。
 * 这个思路初看起来是正确的，但却做了很多无用功，如果一个长的子串包含另一个短一些的子串，那么对子串的回文判断其实是不需要的。
 */
public class LongestPalindromeFromMiddle {
	public static void main(String[] args) {
		System.out.println(logestPalindrome("aabcdcbad"));
		System.out.println(logestPalindrome("aabcddcbad"));
		System.out.println(logestPalindrome("a"));
		System.out.println(logestPalindrome("aba"));
		System.out.println(logestPalindrome("abba"));
	}

	/**
	 * 解法二、O(N)解法
     * 在上文的解法一：枚举中心位置中，我们需要特别考虑字符串的长度是奇数还是偶数，
     * 所以导致我们在编写代码实现的时候要把奇数和偶数的情况分开编写
	 * @param str
	 * @return
	 */
	public static String logestPalindrome(String str) {
		if (str == null || str.trim().length() == 0) {
			return "";
		}

		String result = "";
		for (int i = 0; i < str.length(); i++) {
			String temp = isPalindrome(str, i, i);
			if (temp.length() > result.length()) {
				result = temp;
			}

			temp = isPalindrome(str, i, i + 1);
			if (temp.length() > result.length()) {
				result = temp;
			}
		}
		return result;
	}

	public static String isPalindrome(String str, int start, int end) {
		while (start >= 0 && end <= str.length() - 1 && str.charAt(start) == str.charAt(end)) {
			start--;
			end++;
		}
		return str.substring(start + 1, end);
	}
}