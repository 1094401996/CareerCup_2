package twodot2;

import SLinkedList.SLinkedList;
import SLinkedList.SNode;

// define when k = 1 , return the last node(tail)
public class IthSNode {
	public static void main(String[]args){
		int[] data = {3,5,6,7,57,5,1,2,3,4};
		SLinkedList s = new SLinkedList(data);
		int i = 3;
		SNode node1 = s.ithNodeFromTail1(i);
		System.out.println(node1.getVal());
		SNode node2 = s.ithNodeFromTail2(i);
		System.out.println(node2.getVal());
		SNode node3 = s.ithNodeFromTial3(i);
		System.out.println(node3.getVal());
		s.printList();
	}
}
