package alg.sort;

public class CountSort2 extends AbstractSort {
	@Override
	protected void sort(int[] datas) {
		int min = datas[0];
		int max = datas[0];
		for (int i = 1; i < datas.length; i++) {
			if (datas[i] < min) {
				min = datas[i];
			}
			if (datas[i] > max) {
				max = datas[i];
			}
		}

		int range = max - min + 1;
		int[] help = new int[range];
		for (int i = 0; i < datas.length; i++) {
			help[datas[i] - min]++;
		}

		int index = 0;
		for (int i = 0; i < help.length; i++) {
			while (help[i]-- > 0) {
				datas[index++] = i + min;
			}
		}
	}
}