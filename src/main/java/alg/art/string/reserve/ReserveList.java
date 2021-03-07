package alg.art.string.reserve;

import alg.util.LinkNode;

/**
 * 链表翻转
 */
public class ReserveList {
	public static void main(String[] args) {
		System.out.println(iterationReserve(LinkNode.buildSNode(new int[] { 1, 2, 3, 4, 5, 6 })));
		System.out.println(recursionReserve(LinkNode.buildSNode(new int[] { 1, 2, 3, 4, 5, 6 })));
	}

	/**
	 * 链表翻转迭代: 1->2->3->4->5->6->null 6->5->4->3->2->1->null
	 */
	public static LinkNode iterationReserve(LinkNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		LinkNode newNode = null;
		LinkNode curNode = head;
		while (curNode != null) {
			LinkNode next = curNode.next;
			curNode.next = newNode;
			newNode = curNode;
			curNode = next;
		}
		return newNode;
	}

	/**
	 * 链表翻转递归:1->2->3->4->5->6->null 6->5->4->3->2->1->null
	 */
	public static LinkNode recursionReserve(LinkNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		LinkNode newHead = recursionReserve(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}