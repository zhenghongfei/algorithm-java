package alg.art.array.lcs;

import java.util.Stack;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "fjssharpsword";
		String str2 = "helloworld";
		// 计算lcs递归矩阵
		int[][] re = longestCommonSubsequence(str1, str2);
		// 打印矩阵
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				System.out.print(re[i][j] + "   ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
		// 输出LCS
		print(re, str1, str2, str1.length(), str2.length());
		print2(re, str1.toCharArray(), str2.toCharArray());
	}

	// 假如返回两个字符串的最长公共子序列的长度
	public static int[][] longestCommonSubsequence(String str1, String str2) {
		int[][] matrix = new int[str1.length() + 1][str2.length() + 1];// 建立二维矩阵
		// 初始化边界条件
		for (int i = 0; i <= str1.length(); i++) {
			matrix[i][0] = 0;// 每行第一列置零
		}
		for (int j = 0; j <= str2.length(); j++) {
			matrix[0][j] = 0;// 每列第一行置零
		}
		// 填充矩阵
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = (matrix[i - 1][j] >= matrix[i][j - 1] ? matrix[i - 1][j] : matrix[i][j - 1]);
				}
			}
		}
		return matrix;
	}

	// 根据矩阵输出LCS
	public static void print(int[][] opt, String X, String Y, int i, int j) {
		if (i == 0 || j == 0) {
			return;
		}
		if (X.charAt(i - 1) == Y.charAt(j - 1)) {
			print(opt, X, Y, i - 1, j - 1);
			System.out.print(X.charAt(i - 1));
		} else if (opt[i - 1][j] >= opt[i][j]) {
			print(opt, X, Y, i - 1, j);
		} else {
			print(opt, X, Y, i, j - 1);
		}
	}

	public static void print2(int[][] newArr, char[] array, char[] data) {
		Stack<Character> stack = new Stack<>();
		int m = array.length - 1;
		int n = data.length - 1;
		while (n >= 0 && m >= 0) {// 数组从后向前遍历
			if (array[m] == data[n]) {// 字符相同则入栈
				stack.push(array[m]);
				m--;
				n--;
			} else {
				if (newArr[m + 1][n] > newArr[m][n + 1]) {// 字符不同时，根据打印出的二维矩阵（测试数据）查找上一个相同的字符
					n--;
				} else {
					m--;
				}
			}
		}

		System.out.println();
		while (!stack.isEmpty()) {// 打印出最长的递增子序列
			System.out.print(stack.pop() + ",");
		}
	}
}