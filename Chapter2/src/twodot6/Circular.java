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
 * ����ƪ����˵�ĺܺ�
 * http://keep.iteye.com/blog/293454
 * http://blog.csdn.net/fty8788/article/details/6531280
 * 
 * ֤�������л��ķ�����
 * ����һ�������ҵ���ڵ㣩
 * ��򵥵ķ���, ��һ��ָ���������, ÿ����һ���ڵ�Ͱ������ڴ��ַ(java�п�����object.hashcode())��Ϊkey����һ��hashtable��. 
 * ������hashtable�г����ظ�key��ʱ��˵�����������л�. ���������ʱ�临�Ӷ�ΪO(n), �ռ�ͬ��ΪO(n). 
 * 
 * �����������Ҳ�����ڵ㣩���˷�����˼��ܵ�
 * ʹ�÷�תָ��ķ���, ÿ��һ���ڵ�ͰѸýڵ��ָ�뷴�򣬿���ȥ����һ����ֵķ���: ���л���ʱ��תnextָ��������ߵ�����ͷ��; 
 * ��û�л���ʱ��תnextָ����ƻ�����ṹ(ʹ������), ������Ҫ���������ٷ���һ��. ���ַ����Ŀռ临�Ӷ���O(1), 
 * ʵ��������ʹ����3������ָ��;��ʱ�临�Ӷ���O(n), �������2�α�����������(��������û�л���ʱ��).
 * 
 * �������������ҵ���ڵ㣩
 * ��ָ�����ָ��
 * ��������ָ��(fast, slow)����ʼֵ��ָ��ͷ��slowÿ��ǰ��һ����fastÿ��ǰ�����������������ڻ�����fast�ض��Ƚ��뻷��
 * ��slow����뻷������ָ��ض�������(��Ȼ��fast����ͷ��β��ΪNULL����Ϊ�޻�����)
 * ����ڵ㣺
 * �ҵ�������ڵ�
 * ��fast����slow����ʱ��slow�϶�û���߱�����������fast�Ѿ��ڻ���ѭ����nȦ(1<=n)������slow����s����
 * ��fast����2s����fast����������s �����ڻ��϶�ת��nȦ�����軷��Ϊr����2s = s + nr  => s= nr 
 * ����������L����ڻ������������Ϊx����㵽����ڵ�ľ���Ϊa��
 * a + x = nr
 * a + x = (n �C 1)r +r = (n-1)r + L - a
 * a = (n-1)r + (L �C a �C x)
 * (L �C a �C x)Ϊ�����㵽����ڵ�ľ��룬�ɴ˿�֪��������ͷ������ڵ����(n-1)ѭ���ڻ�+�����㵽����ڵ㣬
 * �������Ǵ�����ͷ����������ֱ���һ��ָ�룬ÿ�θ���һ��������ָ��ض���������������һ��Ϊ����ڵ㡣
 * 
 * ��չ���⣺
 * �ж������������Ƿ��ཻ������ཻ�������ཻ�ĵ�һ���㣨�������������ڻ�����
 * �ȽϺõķ�����������
 * һ��������һ��������β�������������һ�������Ƿ���ڻ���������ڣ������������ཻ��������������������ڼ�Ϊ�ཻ�ĵ�һ���㡣
 * ����������������ཻ���Ǹ�����������ཻ�㵽�������������ͬ�Ľڵ㣬���ǿ����ȱ���һ������ֱ��β�����ٱ�������һ���������Ҳ
 * �����ߵ�ͬ���Ľ�β�㣬�����������ཻ��ʱ���Ǽ�����������length���ٱ���һ�Σ�������ڵ��ȳ���ǰ��(lengthMax-lengthMin)����֮
 * ����������ͬʱǰ����ÿ��һ���������ĵ�һ�㼴Ϊ���������ཻ�ĵ�һ���㡣
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
