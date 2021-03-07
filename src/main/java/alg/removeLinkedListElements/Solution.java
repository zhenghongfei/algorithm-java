package alg.removeLinkedListElements;

/**
 * <PRE>
 * 	删除链表中等于给定值val的所有节点。
 *	样例
 *	给出链表 1->2->3->3->4->5->3, 和 val = 3, 你需要返回删除3之后的链表：1->2->4->5。
 * </PRE>
 * 
 * @author Hongfei 2016年4月4日
 * @since 0.1
 */
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		ListNode prevNode = null;
		ListNode currNode = head;
		while (currNode != null) {
			if (currNode.val == val) {
				if (prevNode == null) {
					head = currNode.next;
				} else {
					prevNode.next = currNode.next;
				}
			} else {
				prevNode = currNode;
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
		}
	}
}