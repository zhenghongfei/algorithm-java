package alg.search;

/**
 * 行列递增矩阵的查找 题目描述
 * 在一个m行n列二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 例如下面的二维数组就是每行、每列都递增排序。如果在这个数组中查找数字6，则返回true；如果查找数字5，由于数组不含有该数字，则返回false。
 */
public class MatrixSearch {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 2, 3, 4, 5 }, { 3, 4, 5, 6 }, { 4, 5, 6, 7 } };

		int k = 1;
		int rows = matrix.length;
		int cols = matrix[0].length;

		int row = 0;
		int col = cols - 1;
		while (row < rows && col >= 0) {
			int data = matrix[row][col];
			if (data == k) {
				System.out.println(data + ",row=" + row + ",col=" + col);
				break;
			} else if (data > k) {
				col--;
			} else {
				row++;
			}
		}
	}
}
