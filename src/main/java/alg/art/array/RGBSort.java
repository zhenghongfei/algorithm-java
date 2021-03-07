package alg.art.array;

import java.util.Arrays;

/**
 * 荷兰国旗 题目描述 拿破仑席卷欧洲大陆之后，代表自由，平等，博爱的竖色三色旗也风靡一时。荷兰国旗就是一面三色旗（只不过是横向的），自上而下为红白蓝三色。
 * 
 * 该问题本身是关于三色球排序和分类的，由荷兰科学家Dijkstra提出。由于问题中的三色小球有序排列后正好分为三类，Dijkstra就想象成他母国的国旗，于是问题也就被命名为荷兰旗问题（Dutch
 * National Flag Problem）。
 * 
 * 下面是问题的正规描述： 现有n个红白蓝三种不同颜色的小球，乱序排列在一起，请通过两两交换任意两个球，使得从左至右，依次是一些红球、一些白球、一些蓝球。
 * 
 * 分析与解法 初看此题，我们貌似除了暴力解决并无好的办法，但联想到我们所熟知的快速排序算法呢？
 * 
 * 我们知道，快速排序依托于一个partition分治过程，在每一趟排序的过程中，选取的主元都会把整个数组排列成一大一小的部分，那我们是否可以借鉴partition过程设定三个指针完成重新排列，使得所有球排列成三个不同颜色的球呢？
 *
 */
public class RGBSort {

	public static void main(String[] args) {
		int[] datas = { 1, 2, 0, 1, 1, 2, 2, 0, 2, 1, 0 };
		int left = 0;
		int right = datas.length - 1;
		int index = 0;
		while (index <= right) {
			if (datas[index] == 0) {
				if (datas[left] != 0) {
					swap(datas,left,index);
				}
				left++;
				index++;
			} else if (datas[index] == 1) {
				index++;
			} else {
				if (datas[right] != 2) {
					swap(datas,right,index);
				}
				right--;
			}
		}
		System.out.println(Arrays.toString(datas));
	}

	static void swap(int[] datas, int i, int j) {
		int temp = datas[i];
		datas[i] = datas[j];
		datas[j] = temp;
	}
}
