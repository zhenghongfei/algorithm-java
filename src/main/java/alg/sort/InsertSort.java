package alg.sort;

/**
 * 插入排序
 * 
 * <pre>
 * http://www.cnblogs.com/fanyong/archive/2012/03/23/2413553.html 
 * <p>时间复杂度
 *　<li>数组在已排序或者是“近似排序”时，插入排序效率的最好情况运行时间为O(n)
 * <li>插入排序最坏情况运行时间和平均情况运行时间都为O(n^2)
 * </pre>
 */
public class InsertSort extends AbstractSort {
	@Override
	protected void sort(int[] datas) {
		for (int i = 1; i < datas.length; i++) {
			int insertNum = datas[i];
			int j = i - 1;
			while (j >= 0 && datas[j] > insertNum) {
				datas[j + 1] = datas[j];
				j--;
			}
			datas[j + 1] = insertNum;
		}
	}

	public void sort0(int[] datas) {
		for (int i = 1; i < datas.length; i++) {
			int insertNum = datas[i];
			int j = i - 1;
			for (; j >= 0 && datas[j] > insertNum; j--) {
				datas[j + 1] = datas[j];
			}
			datas[j + 1] = insertNum;
		}
	}

	public void sort1(int[] datas) {
		for (int i = 1; i < datas.length; i++) {
			for (int j = i - 1; j >= 0 && datas[j] > datas[j + 1]; j--) {
				swap(datas, j, j + 1);
			}
		}
	}

	public void sort2(int[] datas) {
		for (int i = 1; i < datas.length; i++) {
			for (int j = i; j > 0 && datas[j] < datas[j - 1]; j--) {
				swap(datas, j, j - 1);
			}
		}
	}
}