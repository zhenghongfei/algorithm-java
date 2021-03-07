package alg.util;

/**
 * 单向链表节点
 */
public class LinkNode {
	public int val;
	public LinkNode next;

	public LinkNode(int x) {
		val = x;
		next = null;
	}

	public static LinkNode buildSNode(int[] vals) {
		LinkNode head = new LinkNode(vals[0]);
		LinkNode prevNode = head;
		for (int i = 1; i < vals.length; i++) {
			LinkNode newNode = new LinkNode(vals[i]);
			prevNode.next = newNode;
			prevNode = newNode;
		}
		System.out.println(head);
		return head;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}

	public String output() {
		StringBuilder builder = new StringBuilder();
		builder.append(val).append("->");
		LinkNode temp = next;
		while (temp != null) {
			builder.append(temp.val).append("->");
			temp = temp.next;
		}
		if (temp == null) {
			builder.append("null");
		}
		return builder.toString();
	}
}