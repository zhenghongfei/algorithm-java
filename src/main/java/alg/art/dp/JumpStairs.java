package alg.art.dp;

/**
 * 跳台阶问题 题目描述 一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级。
 * 
 * 求总共有多少总跳法，并分析算法的时间复杂度。
 * 
 * 分析与解法 解法一
 * 首先考虑最简单的情况。如果只有1级台阶，那显然只有一种跳法。如果有2级台阶，那就有两种跳的方法了：一种是分两次跳，每次跳1级；另外一种就是一次跳2级。
 * 
 * 现在我们再来讨论一般情况。我们把n级台阶时的跳法看成是n的函数，记为f(n)。
 * 
 * 当n>2时，第一次跳的时候就有两种不同的选择： 一是第一次只跳1级，此时跳法数目等于后面剩下的n-1级台阶的跳法数目，即为f(n-1)；
 * 另外一种选择是第一次跳2级，此时跳法数目等于后面剩下的n-2级台阶的跳法数目，即为f(n-2)。
 * 因此n级台阶时的不同跳法的总数f(n)=f(n-1)+f(n-2)。
 * 
 * 我们把上面的分析用一个公式总结如下：
 *         /  1                             n = 1
f(n)=      2                             n = 2
        \  f(n-1) + f(n-2)               n > 2
 *
 */
public class JumpStairs {

	public static void main(String[] args) {
		int steps = new JumpStairs().jumpStairs(10);
		System.out.println(steps);
	}

	private int jumpStairs(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return jumpStairs(n - 1) + jumpStairs(n - 2);
	}
}