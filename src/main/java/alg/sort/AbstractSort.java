package alg.sort;

/**
 * https://jingyan.baidu.com/article/db55b609f856604ba30a2f18.html
 * https://www.jianshu.com/p/5e171281a387 Java常用的八种排序算法与代码实现
 */
public abstract class AbstractSort {
	private int[] datas;

	public AbstractSort() {
		this.datas = createDatas();
	}

	protected abstract void sort(int[] datas);

	public void testSort() {
		sort(datas);
		output(datas);
	}

	public void swap(int[] arr, int a, int b) {
		arr[a] = arr[a] + arr[b];
		arr[b] = arr[a] - arr[b];
		arr[a] = arr[a] - arr[b];
	}

	public int[] createDatas() {
		return new int[] { 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
	}

	public void output(int[] datas) {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(":");
		for (int data : datas) {
			builder.append(data).append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		System.out.println(builder.toString());
	}

	public int[] getDatas() {
		return datas;
	}

	public void setDatas(int[] datas) {
		this.datas = datas;
	}
}