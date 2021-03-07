package alg.art.array.lis;

/**
 * 题目：小猴子下山，沿着下山的路有一排桃树，每棵树都结了一些桃子。小猴子想摘桃子，但是又一些条件需要遵守，小瘦子只能沿着下山的方向走，不能回头，每棵树最多摘一个，而且一旦摘了一棵树的桃子，就不能再摘比这棵树结的桃子少的树上的桃子，那么小猴子最多能摘到几课桃子呢？
 * 距离说明，比如有五棵树，分别结了10，4，5，12，8棵桃子，那么小猴子最多能摘3颗桃子，来自于结了4，5，12颗桃子的桃树。
 * 
 * 输入范例： 5 10 4 5 12 8 输出范例： 3
 * 
 * 看到题第一反应就是最长递增子序列，学习自《编程之美》这本书。
 *
 */
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		int datas[] = new int[] { 5, 10, 4, 5, 12, 8 };
		maxLISLengh(datas);
		search_max_asc1_1(datas);
	}

	private static void maxLISLengh(int[] datas) {
		// 用于存储以当前元素为结尾的最长递增子序列长度
		int dp[] = new int[datas.length];

		int max = 0;
		for (int i = 0; i < datas.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (datas[i] > datas[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
	
	private static String search_max_asc1_1(int[] arry) {
        int[] lis = new int[arry.length];
        String[] str = new String[arry.length];
        for (int i = 0; i < arry.length; i++) {
            str[i] = arry[i] + "";
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arry[i] > arry[j] && lis[j] + 1 > lis[i]) {
                    lis[i] = lis[j] + 1;
                    str[i] = str[j];
                    str[i] += "," + arry[i];
                }
            }
        }
        int n = max_num(lis);
        return str[n];
    }
	
	private static int max_num(int[] lis) {
        int max = lis[0];
        int num = 0;
        for (int i = 1; i < lis.length; i++) {
            if (lis[i] > max) {
                max = lis[i];
                num = i;
            }
        }
        return num;
    }

}
