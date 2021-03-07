package alg.sort;

/**
 * http://www.cnblogs.com/chengxiao/p/6129630.html
 * 堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)，它也是不稳定排序。
 * <P>
 * 首先简单了解下堆结构
 *　<li>堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
 * <li>或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 * 
 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，此时末尾就为最大值。
 * 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
 */
public class HeapSortDesc extends AbstractSort {

	@Override
	protected void sort(int[] datas) {
		// 1.构建大顶堆
		for (int i = datas.length / 2 - 1; i >= 0; i--) {
			// 从第一个非叶子结点从下至上，从右至左调整结构
			adjustHeap(datas, i, datas.length);
		}
		// 2.调整堆结构+交换堆顶元素与末尾元素
		for (int j = datas.length - 1; j > 0; j--) {
			swap(datas, 0, j);// 将堆顶元素与末尾元素进行交换
			adjustHeap(datas, 0, j);// 重新对堆进行调整
		}
	}

	/**
	 * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
	 * 
	 * @param arr
	 * @param i
	 * @param length
	 */
	public static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];// 先取出当前元素i
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {// 从i结点的左子结点开始，也就是2i+1处开始
			if (k + 1 < length && arr[k] > arr[k + 1]) {// 如果左子结点小于右子结点，k指向右子结点
				k++;
			}
			if (arr[k] < temp) {// 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;// 将temp值放到最终的位置
	}

	/**
	 * 交换元素
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 */
	public void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		HeapSortDesc heapSort = new HeapSortDesc();
		heapSort.testSort();
	}
}