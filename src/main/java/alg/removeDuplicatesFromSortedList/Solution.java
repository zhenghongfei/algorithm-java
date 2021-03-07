package alg.removeDuplicatesFromSortedList;

/**
 * <PRE>
 * 	给定一个排序链表，删除所有重复的元素每个元素只留下一个。
 *	样例
 *	给出 1->1->2->null，返回 1->2->null
 *	给出 1->1->2->3->3->null，返回 1->2->3->null
 * </PRE>
 * 
 * @author Hongfei 2016年4月4日
 * @since 0.1
 */
public class Solution {
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode prevNode = null;
		ListNode currNode = head;
		while (currNode != null) {
			if (prevNode == null) {
				prevNode = currNode;
			} else {
				if (prevNode.val == currNode.val) {
					prevNode.next = currNode.next;
				} else {
					prevNode = currNode;
				}
			}
			currNode = currNode.next;
		}
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}