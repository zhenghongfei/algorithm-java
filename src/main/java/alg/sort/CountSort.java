package alg.sort;

public class CountSort extends AbstractSort {
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

		for (int i = 1; i < help.length; i++) {
			help[i] += help[i - 1];
		}

		int[] temp = new int[datas.length];
		for (int i = 0; i < datas.length; i++) {
			int pos = --help[datas[i] - min];
			temp[pos] = datas[i];
		}

		setDatas(temp);
	}
}