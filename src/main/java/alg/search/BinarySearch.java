package alg.search;

public class BinarySearch extends AbstractSearch {

	@Override
	protected int search(int[] datas, int input) {
		int low = 0;
		int high = datas.length - 1;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (datas[mid] < input) {
				low = mid + 1;
			} else if (datas[mid] > input) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public int search0(int input) {
		return iterSearch(getDatas(), input, 0, getDatas().length - 1);
	}

	public int iterSearch(int[] datas, int input, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (datas[mid] < input) {
				return iterSearch(datas, input, mid + 1, high);
			} else if (datas[mid] > input) {
				return iterSearch(datas, input, low, mid - 1);
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		BinarySearch bs = new BinarySearch();
		int[] datas1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.err.println(bs.search(datas1, 1));
		System.err.println(bs.search(datas1, 2));
		System.err.println(bs.search(datas1, 3));
		System.err.println(bs.search(datas1, 4));
		System.err.println(bs.search(datas1, 5));
		System.err.println(bs.search(datas1, 6));
		System.err.println(bs.search(datas1, 7));
		System.err.println(bs.search(datas1, 8));
		System.err.println(bs.search(datas1, 9));
		System.err.println(bs.search(datas1, 0));
		System.err.println(bs.search(datas1, 10));
	}
}