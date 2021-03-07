package alg.art.array.lcs;

/**
 * 最长公共子串（LCS）
 * 
 * 找两个字符串的最长公共子串，这个子串要求在原字符串中是连续的。其实这又是一个序贯决策问题，可以用动态规划来求解。我们采用一个二维矩阵来记录中间的结果。这个二维矩阵怎么构造呢？直接举个例子吧："bab"和"caba"(当然我们现在一眼就可以看出来最长公共子串是"ba"或"ab")
 * 
 * b a b
 * 
 * c 0 0 0
 * 
 * a 0 1 0
 * 
 * b 1 0 1
 * 
 * a 0 1 0
 * 
 * 我们看矩阵的斜对角线最长的那个就能找出最长公共子串。
 * 
 * 不过在二维矩阵上找最长的由1组成的斜对角线也是件麻烦费时的事，下面改进：当要在矩阵是填1时让它等于其左上角元素加1。
 * 
 * b a b
 * 
 * c 0 0 0
 * 
 * a 0 1 0
 * 
 * b 1 0 2
 * 
 * a 0 2 0
 * 
 * 这样矩阵中的最大元素就是 最长公共子串的长度。
 * 
 * 在构造这个二维矩阵的过程中由于得出矩阵的某一行后其上一行就没用了，所以实际上在程序中可以用一维数组来代替这个矩阵。
 * 
 * 代码如下：
 *
 */
public class LongestCommonSubstring {

	public static void main(String[] args) {
		String str1 = "bab";
		String str2 = "caba";
		int[] temp = new int[str1.length()];
		int[] curr = new int[str1.length()];
		int max = 0;
		int pos = 0;

		for (int i = 0; i < str2.length(); i++) {
			curr = new int[str1.length()];
			for (int j = 0; j < str1.length(); j++) {
				if (str2.charAt(i) == (str1.charAt(j))) {
					if (j == 0) {
						curr[j] = 1;
					} else {
						curr[j] = temp[j - 1] + 1;
					}
					if (max < curr[j]) {
						max = curr[j];
						pos = j;
					}
				}
			}
			temp = curr;
		}
		System.out.println(max + "," + pos);
	}
}
