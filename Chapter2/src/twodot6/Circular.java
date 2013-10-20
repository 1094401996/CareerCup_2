package twodot6;

import SLinkedList.SLinkedList;
import SLinkedList.SNode;

/**
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 * DEFINITION
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * EXAMPLE
 * Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 * Output: C
 * 这两篇文章说的很好
 * http://keep.iteye.com/blog/293454
 * http://blog.csdn.net/fty8788/article/details/6531280
 * 
 * 证明链表有环的方法：
 * 方法一：（能找到入口点）
 * 最简单的方法, 用一个指针遍历链表, 每遇到一个节点就把他的内存地址(java中可以用object.hashcode())做为key放在一个hashtable中. 
 * 这样当hashtable中出现重复key的时候说明此链表上有环. 这个方法的时间复杂度为O(n), 空间同样为O(n). 
 * 
 * 方法二：（找不到入口点），此方法的思想很吊
 * 使用反转指针的方法, 每过一个节点就把该节点的指针反向，看上去这是一种奇怪的方法: 当有环的时候反转next指针会最终走到链表头部; 
 * 当没有环的时候反转next指针会破坏链表结构(使链表反向), 所以需要最后把链表再反向一次. 这种方法的空间复杂度是O(1), 
 * 实事上我们使用了3个额外指针;而时间复杂度是O(n), 我们最多2次遍历整个链表(当链表中没有环的时候).
 * 
 * 方法三：（能找到入口点）
 * 快指针和慢指针
 * 设置两个指针(fast, slow)，初始值都指向头，slow每次前进一步，fast每次前进二步，如果链表存在环，则fast必定先进入环，
 * 而slow后进入环，两个指针必定相遇。(当然，fast先行头到尾部为NULL，则为无环链表)
 * 找入口点：
 * 找到环的入口点
 * 当fast若与slow相遇时，slow肯定没有走遍历完链表，而fast已经在环内循环了n圈(1<=n)。假设slow走了s步，
 * 则fast走了2s步（fast步数还等于s 加上在环上多转的n圈），设环长为r，则：2s = s + nr  => s= nr 
 * 设整个链表长L，入口环与相遇点距离为x，起点到环入口点的距离为a。
 * a + x = nr
 * a + x = (n – 1)r +r = (n-1)r + L - a
 * a = (n-1)r + (L – a – x)
 * (L – a – x)为相遇点到环入口点的距离，由此可知，从链表头到环入口点等于(n-1)循环内环+相遇点到环入口点，
 * 于是我们从链表头、与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇第一点为环入口点。
 * 
 * 扩展问题：
 * 判断两个单链表是否相交，如果相交，给出相交的第一个点（两个链表都不存在环）。
 * 比较好的方法有两个：
 * 一、将其中一个链表首尾相连，检测另外一个链表是否存在环，如果存在，则两个链表相交，而检测出来的依赖环入口即为相交的第一个点。
 * 二、如果两个链表相交，那个两个链表从相交点到链表结束都是相同的节点，我们可以先遍历一个链表，直到尾部，再遍历另外一个链表，如果也
 * 可以走到同样的结尾点，则两个链表相交。时我们记下两个链表length，再遍历一次，长链表节点先出发前进(lengthMax-lengthMin)步，之
 * 后两个链表同时前进，每次一步，相遇的第一点即为两个链表相交的第一个点。
 */
class Result{
	 boolean isCircular ;
	 SNode entrance;
	 Result(boolean isCircular, SNode entrance){
		 this.isCircular = isCircular;
		 this.entrance = entrance;
		 
	 }
}

public class Circular {
	
	public static void main(String[]args){
		int [] data = {1,2,3,4};
		SLinkedList s = new SLinkedList(data);
		SLinkedList s1 = new SLinkedList(data);
		SNode node = new SNode(-1,null);
		s.append(node);
		s.append(5);
		s.append(6);
		s.append(7);
		s.append(8);
		s.append(9);
		s.append(10);
		s.append(11);
		s.getTail().setNext(node);		
		System.out.println(isCircular(s1).isCircular );
		System.out.println(isCircular(s).isCircular );
		System.out.println(isCircular(s).entrance.getVal());
	}
	public static Result  isCircular(SLinkedList L){
		SNode slow, fast;
		slow = fast = L.getHead();
		while(fast != null && fast.getNext() != null){
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if(fast == null || fast.getNext() == null){
				return new Result(false,null);
			}
			if(slow == fast){
				break;
		   }
		}
		SNode prev = L.getHead();
		while(slow != prev){
			slow = slow.getNext();
			prev = prev.getNext();
		}
			return new Result(true,prev);
	}
}
