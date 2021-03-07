package alg.sort;

public class BubbleSort extends AbstractSort {
	@Override
	protected void sort(int[] datas) {
		for (int i = 0; i < datas.length - 1; i++) {
			for (int j = i + 1; j < datas.length; j++) {
				if (datas[i] > datas[j]) {
					swap(datas, i, j);
				}
			}
		}
	}
}
