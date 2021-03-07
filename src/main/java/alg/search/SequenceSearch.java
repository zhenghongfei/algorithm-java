package alg.search;

public class SequenceSearch extends AbstractSearch {

	@Override
	protected int search(int[] datas, int input) {
		for (int i = 0; i < datas.length; i++) {
			if (datas[i] == input) {
				return i;
			}
		}
		return -1;
	}

}
