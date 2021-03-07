package alg.art.string.palindrome;

/**
 * 题目一描述 回文，英文palindrome，指一个顺着读和反过来读都一样的字符串，比如madam、我爱我，这样的短句在智力性、
 * 趣味性和艺术性上都颇有特色，中国历史上还有很多有趣的回文诗。
 * 
 * 那么，我们的第一个问题就是：判断一个字串是否是回文？
 * 
 * ==============================================================================================
 * 分析与解法 回文判断是一类典型的问题，尤其是与字符串结合后呈现出多姿多彩，在实际中使用也比较广泛，
 * 而且也是面试题中的常客，所以本节就结合几个典型的例子来体味下回文之趣。
 */
public class PalindromeFrom2End {
	public static void main(String[] args) {
		System.out.println(isPalindrome(null));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("  "));
		System.out.println(isPalindrome("baba"));

		System.out.println(isPalindrome("a"));
		System.out.println(isPalindrome("bab"));
		System.out.println(isPalindrome("ababa"));
		System.out.println(isPalindrome("abba"));
	}

	/**
	 * <PRE>
	 * 解法一
	 * 同时从字符串头尾开始向中间扫描字串，如果所有字符都一样，那么这个字串就是一个回文。
	 * 采用这种方法的话，我们只需要维护头部和尾部两个扫描指针即可。
	 * 这是一个直白且效率不错的实现，时间复杂度：O(n)，空间复杂度：O(1)。
	 * </PRE>
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		if (s == null || s.trim().length() == 0) {
			return false;
		}

		if (s.length() == 1) {
			return true;
		}

		for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
		}
		return true;
	}
}