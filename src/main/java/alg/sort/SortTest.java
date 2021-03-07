package alg.sort;

public class SortTest {

	public static void main(String[] args) {
		testInsertSort();
		testShellSort();
		testSelectSort();
		testBubbleSort();
		testMergeSort();
		testQuickSort();
		testHeapSort();
		testCountSort();
	}

	private static void testCountSort() {
		CountSort cs = new CountSort();
		cs.testSort();
		
		cs.setDatas(new int[] { 1, 4, 4, 5, 3, 3, 6 });
		cs.testSort();

		cs.setDatas(new int[] { 2, 2, 4, 4, 5, 3, 3, 6, 9 });
		cs.testSort();
		
		CountSort2 cs2 = new CountSort2();
		cs2.testSort();
		
		cs2.setDatas(new int[] { 1, 4, 4, 5, 3, 3, 6 });
		cs2.testSort();
		
		cs2.setDatas(new int[] { 2, 2, 4, 4, 5, 3, 3, 6, 9 });
		cs2.testSort();
	}

	private static void testHeapSort() {
		HeapSort heapSort = new HeapSort();
		heapSort.testSort();
	}

	private static void testQuickSort() {
		QuickSort quickSort = new QuickSort();
		quickSort.testSort();

		QuickSortFromLeft quickSortFromLeft = new QuickSortFromLeft();
		quickSortFromLeft.testSort();

		quickSortFromLeft.setDatas(new int[] { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 });
		quickSortFromLeft.testSort();

		QuickSortFromRight quickSortFromRight = new QuickSortFromRight();
		quickSortFromRight.testSort();

		quickSortFromRight.setDatas(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });
		quickSortFromRight.testSort();

		QuickSortFromMid quickSortFromMid = new QuickSortFromMid();
		quickSortFromMid.testSort();

		quickSortFromMid.setDatas(new int[] { 1, 4, 6, 5, 3 });
		quickSortFromMid.testSort();
	}

	private static void testMergeSort() {
		MergeSort mergeSort = new MergeSort();
		mergeSort.testSort();

		MergeSort1 mergeSort1 = new MergeSort1();
		mergeSort1.testSort();
	}

	private static void testBubbleSort() {
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.testSort();
	}

	private static void testSelectSort() {
		SelectSort selectSort = new SelectSort();
		selectSort.testSort();
	}

	private static void testShellSort() {
		ShellSort shellSort = new ShellSort();
		shellSort.testSort();

		int[] datas0 = shellSort.createDatas();
		shellSort.sort0(datas0);
		shellSort.output(datas0);

		int[] datas1 = shellSort.createDatas();
		shellSort.sort1(datas1);
		shellSort.output(datas1);
	}

	private static void testInsertSort() {
		InsertSort insertSort = new InsertSort();
		insertSort.testSort();

		int[] datas0 = insertSort.createDatas();
		insertSort.sort0(datas0);
		insertSort.output(datas0);

		int[] datas1 = insertSort.createDatas();
		insertSort.sort1(datas1);
		insertSort.output(datas1);

		int[] datas2 = insertSort.createDatas();
		insertSort.sort2(datas2);
		insertSort.output(datas2);
	}
}
