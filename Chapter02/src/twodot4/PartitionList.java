package twodot4;

import SLinkedList.SLinkedList;

public class PartitionList {
	public static void main(String[]args){
		int[] data = {3,5,6,7,57,6,1,2,3,4};
		SLinkedList s = new SLinkedList(data);
		s.partitionList(50);
		s.printList();
	}
}
