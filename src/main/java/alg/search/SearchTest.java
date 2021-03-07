package alg.search;

import alg.sort.HeapSort;

public class SearchTest {

	public static void main(String[] args) {
		testSequenceSearch();
		testBinarySearch();
	}

	private static void testSequenceSearch() {
		SequenceSearch sequenceSearch = new SequenceSearch();
		sequenceSearch.testSearch(27);
	}

	private static void testBinarySearch() {
		BinarySearch binarySearch = new BinarySearch();

		HeapSort heapSort = new HeapSort();
		heapSort.setDatas(binarySearch.getDatas());
		heapSort.testSort();

		binarySearch.testSearch(97);
		int index = binarySearch.search0(97);
		binarySearch.output(index);
	}

}
