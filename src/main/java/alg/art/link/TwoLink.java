package alg.art.link;

import alg.util.LinkNode;

public class TwoLink {

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

		LinkNode n6 = new LinkNode(6);
		LinkNode n7 = new LinkNode(7);
		n6.next = n7;
		n7.next = n3;

		LinkNode node1Next = n1;
		while (node1Next != null && node1Next.next != null) {
			node1Next = node1Next.next;
		}

		LinkNode node2Next = n6;
		while (node2Next != null && node2Next.next != null) {
			node2Next = node2Next.next;
		}

		if (node1Next == node2Next) {
			System.out.println("两个链表相交");
		}
	}
}