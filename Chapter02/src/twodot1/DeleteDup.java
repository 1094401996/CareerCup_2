package twodot1;

import SLinkedList.SLinkedList;

public class DeleteDup {
	public static void main(String[]args){
		int[] vals = {1,3,4,4,4,4,4,4};
		SLinkedList sl = new SLinkedList(vals);
		sl.deleterDup();
		sl.printList();
	}
}
