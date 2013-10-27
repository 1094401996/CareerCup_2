package twodot7;

import SLinkedList.SLinkedList;
import SLinkedList.SNode;

//slow and fast runner
//reverse

public class Palindrome {
	public static void main(String[]args){
		int[] data1 = {1,2,2,1,4};
		int[] data2 = {1,2,3,4,3,2,1};
		int[] data3 = {1,2,3,4,4,3,3,1};
		int[] data4 = {1,2,3,4,4,3,2,1};
		SLinkedList s1 = new SLinkedList(data1);
		SLinkedList s2 = new SLinkedList(data2);
		SLinkedList s3 = new SLinkedList(data3);
		SLinkedList s4 = new SLinkedList(data4);
		System.out.println(isPalindrome(s1));
		s1.printList();
	    System.out.println(isPalindrome(s2));
		s2.printList();
		System.out.println(isPalindrome(s3));
		s3.printList();
		System.out.println(isPalindrome(s4));
		s4.printList();
	}
	
	public static boolean isPalindrome(SLinkedList L){
		boolean is = true;
		SNode slow, fast;
		slow = fast = L.getHead();
		while(fast != null && fast.getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		if(fast != null)//the length of list is odd
			slow = slow.getNext();
		SNode curr = slow;
		SNode next = curr.getNext();
		curr.setNext(null);
		while(next != null){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.setNext(temp);	
		}
		SNode pre = L.getHead();
		SNode post = curr;
		while(post != null){
		   if(post.getVal() != pre.getVal()){
			   is = false;
			   break;	
		   }
		   post = post.getNext();
		   pre =  pre.getNext();
		}
		next = curr.getNext();
		curr.setNext(null);
		while(curr != slow){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.setNext(temp);	
		}
		return is;
	}
	
}
