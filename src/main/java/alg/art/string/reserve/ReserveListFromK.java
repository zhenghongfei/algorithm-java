package alg.art.string.reserve;

import alg.util.LinkNode;

/**
 * 链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，
 * 若k=3，翻转后3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
 * 
 * 思路： 使用反转链表的思路，将链表的前部分反转， 然后将链表的后部分反转， 最后将前部分链表的尾节点指向后部分链表的头节点。
 */
public class ReserveListFromK {
	public static void main(String[] args) {
		LinkNode node = LinkNode.buildSNode(new int[] { 1, 2, 3, 4, 5, 6 });
		System.out.println(reverseList(node, 3));
	}

	/**
	 * 链表翻转。给出一个链表和一个数k，比如，链表为1→2→3→4→5→6，k=2，则翻转后2→1→6→5→4→3，若k=3，翻转后
	 * 3→2→1→6→5→4，若k=4，翻转后4→3→2→1→6→5，用程序实现。
	 */
	public static LinkNode reverseList(LinkNode head, int k) {
		LinkNode leftEndNode = head;
		while (k-- > 0) {
			leftEndNode = leftEndNode.next;
		}

		LinkNode left = reverseList(head, leftEndNode);
		LinkNode right = reverseList(leftEndNode, null);
		head.next = right;
		return left;
	}

	public static LinkNode reverseList(LinkNode start, LinkNode end) {
		LinkNode pre = null;
		LinkNode cur = start;
		while (cur != end) {
			LinkNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}