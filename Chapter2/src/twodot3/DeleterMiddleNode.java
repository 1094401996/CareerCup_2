package twodot3;

import SLinkedList.SLinkedList;
import SLinkedList.SNode;

public class DeleterMiddleNode {
	public static void main(String[]args){
		
		int[] data = {3,5,6,7,57,5,1,2,3,4};
		SLinkedList s = new SLinkedList(data);
		int i = 6;
		SNode node1 = s.ithNodeFromTail1(i);
		s.deleterMiddleNode(node1);
		s.printList();
	}
}
