package alg.art.array;

/**
 * 矩阵相乘 题目描述 请编程实现矩阵乘法，并考虑当矩阵规模较大时的优化方法。
 * 
 * 分析与解法
 * 根据wikipedia上的介绍：两个矩阵的乘法仅当第一个矩阵A的行数和另一个矩阵B的列数相等时才能定义。如A是m×n矩阵，B是n×p矩阵，它们的乘积AB是一个m×p矩阵，它的一个元素其中
 * 1 ≤ i ≤ m, 1 ≤ j ≤ p。
 * 
 * 值得一提的是，矩阵乘法满足结合律和分配率，但并不满足交换律，如下图所示的这个例子，两个矩阵交换相乘后，结果变了：
 * 
 * 下面咱们来具体解决这个矩阵相乘的问题。
 */
public class MatrixProduct {

	public static void main(String[] args) {
		// 2*3
		int[][] matrix1 = { { 1, 2, 3 }, { 2, 3, 4 } };
		// 3*2
		int[][] matrix2 = { { 2, 3 }, { 4, 5 }, { 6, 7 } };

		int rows = matrix1.length;
		int cols = matrix1.length;
		int[][] matrix = new int[rows][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				for (int k = 0; k < matrix2.length; k++) {
					matrix[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}