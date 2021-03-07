package alg.art.dp;

import java.util.HashMap;
import java.util.Map;

public class JumpStairsForCache {
	Map<Integer, Integer> cache = new HashMap<>();

	public static void main(String[] args) {
		int steps = new JumpStairsForCache().jumpStairs(10);
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
		if (cache.containsKey(n)) {
			return cache.get(n);
		} else {
			int value = jumpStairs(n - 1) + jumpStairs(n - 2);
			cache.put(n, value);
			return value;
		}
	}
}