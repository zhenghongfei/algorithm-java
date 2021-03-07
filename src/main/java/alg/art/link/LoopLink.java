package alg.art.link;

import alg.util.LinkNode;

public class LoopLink {

	public static void main(String[] args) {
		LinkNode n1 = new LinkNode(1);
		LinkNode n2 = new LinkNode(2);
		LinkNode n3 = new LinkNode(3);
		LinkNode n4 = new LinkNode(4);
		LinkNode n5 = new LinkNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		isLoopLink(n1);
		
		n5.next = n3;
		isLoopLink(n1);
		
		n5.next = n4;
		isLoopLink(n1);
	}

	private static void isLoopLink(LinkNode node) {
		LinkNode slowNode = node;
		LinkNode fastNode = node;

		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
			if (slowNode == fastNode) {
				break;
			}
		}

		if (fastNode == null || fastNode.next == null) {
			System.out.println("无环，单向链表：" + node.output());
			return;
		}

		slowNode = node;
		while (slowNode != fastNode) {
			slowNode = slowNode.next;
			fastNode = fastNode.next;
		}

		System.out.println("有环，入口点为：" + slowNode.val);
	}
}