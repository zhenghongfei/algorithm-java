package alg.sort;

/**
 * 每次循环从剩余未排序的数组中查找最小的元素
 */
public class SelectSort extends AbstractSort {

	@Override
	protected void sort(int[] datas) {
		for (int i = 0; i < datas.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < datas.length; j++) {
				if (datas[j] < datas[min]) {
					min = j;
				}
			}
			if (min != i) {
				swap(datas, min, i);
			}
		}
	}
}
