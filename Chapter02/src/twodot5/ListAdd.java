package twodot5;

import SLinkedList.SLinkedList;
import SLinkedList.SNode;

public class ListAdd {
	public static void main(String[]args){
		int[] a1 = {1,2,3,4,9,9,9};
		int[] a2 = {3,3,4,6};
		SLinkedList L1 = new SLinkedList(a1);
		SLinkedList L2 = new SLinkedList(a2);
		
		SLinkedList sum = new SLinkedList();
		reverseOrderAdd(L1,L2,sum);
		sum.printList();
	}
	
	public static void reverseOrderAdd(SLinkedList L1, SLinkedList L2,SLinkedList sum){
		SNode s1 = L1.getHead();
		SNode s2 = L2.getHead();
		
		int IN = 0;
		while(s1 != null && s2 != null){
			sum.append((s1.getVal() + s2.getVal() + IN)%10);
			IN = (s1.getVal() + s2.getVal() + IN) / 10;
			s1 = s1.getNext();
			s2 = s2.getNext();
		}
		while(s1 != null ){
			IN = (s1.getVal() + IN) / 10;
			sum.append((s1.getVal() + IN)%10);
			s1 = s1.getNext();
			
		}
		while(s2 != null){
			IN = (s2.getVal() + IN) / 10;
			sum.append((s2.getVal() + IN)%10);
			s2 = s2.getNext();
		}
		if(IN == 1){
			sum.append(IN);
		}
		
	}
}
