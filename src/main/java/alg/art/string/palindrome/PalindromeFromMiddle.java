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
public class PalindromeFromMiddle {
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
	 * 解法二 上述解法一从两头向中间扫描，那么是否还有其它办法呢？我们可以先从中间开始、然后向两边扩展查看字符是否相等。
	 * 参考代码如下：
	 * 
	 * 时间复杂度：O(n)，空间复杂度：O(1)。
	 *
	 * 虽然本解法二的时空复杂度和解法一是一样的，但很快我们会看到，在某些回文问题里面，
	 * 这个方法有着自己的独到之处，可以方便的解决一类问题。
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

		int left = s.length() / 2 - 1;
		int right = (s.length() % 2 == 0 ? left + 1 : left + 2);
		for (; left >= 0; left--, right++) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
		}
		return true;
	}
}