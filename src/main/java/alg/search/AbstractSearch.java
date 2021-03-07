package alg.search;

import java.util.Arrays;

/**
 * http://www.cnblogs.com/maybe2030/p/4715035.html
 */
public abstract class AbstractSearch {
	private int[] datas;

	public AbstractSearch() {
		this.datas = createDatas();
	}

	protected abstract int search(int[] datas, int input);

	public void testSearch(int input) {
		int index = search(datas, input);
		output(index);
	}

	public void output(int index) {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(":");
		builder.append(Arrays.toString(datas)).append(":Search Index=");
		builder.append(index);
		System.out.println(builder.toString());
	}

	public void swap(int[] arr, int a, int b) {
		arr[a] = arr[a] + arr[b];
		arr[b] = arr[a] - arr[b];
		arr[a] = arr[a] - arr[b];
	}

	public int[] createDatas() {
		return new int[] { 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
	}

	public int[] getDatas() {
		return datas;
	}

	public void setDatas(int[] datas) {
		this.datas = datas;
	}
}