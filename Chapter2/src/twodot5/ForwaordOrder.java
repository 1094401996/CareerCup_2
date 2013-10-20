package twodot5;

import SLinkedList.SLinkedList;
import SLinkedList.SNode;

/**FOLLOW UP
* Suppose the digits are stored in forward order. Repeat the above problem.
* EXAMPLE
* Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
* Output: 9 -> 1 -> 2. That is, 912.
* 基本方法就是讲链表反转
*/

public class ForwaordOrder {
	public static void main(String[]args){
		int[] n1 = {6,1,7};
		int[] n2 = {9,9,9,6,9,5};
		SLinkedList L1 = new SLinkedList(n1);
		SLinkedList L2 = new SLinkedList(n2);
		SLinkedList sum = new SLinkedList();
		forwardOrderAdd(L1,L2,sum);
		L1.printList();
		L2.printList();
		sum.printList();
		
	}
	
	public static void forwardOrderAdd(SLinkedList L1, SLinkedList L2, SLinkedList sum){
		reverse(L1);
		reverse(L2);
		SNode s1 = L1.getHead();
		SNode s2 = L2.getHead();

	    int carry = 0;
	    while(s1 != null && s2 != null){
	    	int i = (s1.getVal() + s2.getVal() + carry) % 10;
	    	carry = (s1.getVal() + s2.getVal() + carry) / 10;
	    	sum.append(i);
	    	s1 = s1.getNext();
	    	s2 = s2.getNext();
	    }
	    while(s1 != null){
	    	int i = (s1.getVal() + carry) %10;
	    	carry = (s1.getVal()+ carry) / 10;
	    	sum.append(i);
	    	s1 = s1.getNext();
	    }
	    while(s2 != null){
	    	int i = (s2.getVal() + carry) %10;
	    	carry = (s2.getVal()+ carry) / 10;
	    	sum.append(i);
	    	s2 = s2.getNext();
	    }
	    if(carry == 1){
	    	sum.append(carry);
	    }
		reverse(L1);
		reverse(L2);
		reverse(sum);
		
	}
	
	
	
	private static void reverse(SLinkedList L){
		
		SNode curr = L.getHead();
		SNode next = curr.getNext();
		curr.setNext(null); 
		while(next != null){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.setNext(temp);
		}
		SNode temp = L.getHead();
		L.setHead(L.getTail());
        L.setTail(temp);	
	}
	

}
