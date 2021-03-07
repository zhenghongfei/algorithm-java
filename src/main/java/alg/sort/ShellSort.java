package alg.sort;

public class ShellSort extends AbstractSort {

	@Override
	protected void sort(int[] datas) {
		for (int step = datas.length / 2; step > 0; step /= 2) {
			for (int i = step; i < datas.length; i++) {
				for (int j = i - step; j >= 0 && datas[j] > datas[j + step]; j -= step) {
					swap(datas, j, j + step);
				}
			}
		}
	}

	public void sort0(int[] datas) {
		for (int step = datas.length / 2; step > 0; step /= 2) {
			for (int i = step; i < datas.length; i++) {
				int insertNum = datas[i];
				int j = i - step;
				for (; j >= 0 && datas[j] > insertNum; j -= step) {
					datas[j + step] = datas[j];
				}
				datas[j + step] = insertNum;
			}
		}
	}

	public void sort1(int[] datas) {
		for (int step = datas.length / 2; step > 0; step /= 2) {
			for (int i = step; i < datas.length; i++) {
				for (int j = i; (j - step) >= 0 && datas[j] < datas[j - step]; j -= step) {
					swap(datas, j, j - step);
				}
			}
		}
	}
}
