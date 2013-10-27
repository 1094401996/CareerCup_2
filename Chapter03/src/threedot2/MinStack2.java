package threedot2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**career 3.2
 * How would you design a stack which, in addition to push and pop, 
 * also has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 * @author geng
 *  ���õ����ӣ�
 *  http://blog.csdn.net/yysdsyl/article/details/4283806 
 *  http://blog.csdn.net/ssjhust123/article/details/7752878
 *  
 *  method2:
 *  push(int elem)������ջ��ѹ�뵱ǰԪ���뵱ǰջ����СԪ�صĲ�ֵ��Ȼ��ͨ���Ƚϵ�ǰ
 *  Ԫ���뵱ǰջ����СԪ�ش�С�����������м�Ľ�Сֵѹ�롣pop()����ִ�е�ʱ����pop
 *  ��ջ��������ֵ��������ֵ�ֱ��ǵ�ǰջ����Сֵmin�����ѹ���Ԫ����ջ����Сֵ�Ĳ�ֵdiff��
 *  ���diff<0�����ʾ���ѹ��ջ��Ԫ������С��Ԫ�أ����ֻ�轫min-diffѹ��ջ�У�����minֵ���ؼ��ɡ�
 *  min-diff���ǵ�ǰԪ�ص�����ջ��ʣ��Ԫ�ص���Сֵ�������diff>=0��ջ��Ϊ�գ����ʾ��ǰֵ������Сֵ��
 *  ������Ҫ��ջ��ѹ����Сֵmin����diff+min���أ����ջΪ�գ����ʾ�Ѿ������һ�����֣�ֱ�ӷ���min���ɡ�
 *  
 *  
 *  
 *  clear(): [ ] 
push(3): [3 3] 
push(4): [3 1 3] 
push(2): [3 1 -1 2] 
push(5): [3 1 -1 3 2] 
push(1): [3 1 -1 3 -1 1] 
push(1): [3 1 -1 3 -1 0 1] 
push(6): [3 1 -1 3 -1 0 5 1] 
push(7): [3 1 -1 3 -1 0 5 6 1]

min() --> 1; pop() --> 7: [3 1 -1 3 -1 0 5 1] 
min() --> 1; pop() --> 6: [3 1 -1 3 -1 0 1] 
min() --> 1; pop() --> 1: [3 1 -1 3 -1 1] 
min() --> 1; pop() --> 1: [3 1 -1 3 2] 
min() --> 2; pop() --> 5: [3 1 -1 2] 
min() --> 2; pop() --> 2: [3 1 3] 
min() --> 3; pop() --> 4: [3 3] 
min() --> 4; pop() --> 3: [ ]
 */
public class MinStack2 {
	Deque<Integer> s = new ArrayDeque<Integer>();
	public MinStack2(){
		
	}
	
	public void push(int element){
		if(s.isEmpty()){
			s.push(element);
			s.push(element);
		}
		else{
			int min = s.pop();
			int diff = element - min;
			s.push(diff);
			s.push(diff > 0 ?min : element);
		}		
		
	}
	
	public int pop() throws Exception{
		int val;
		if(s.isEmpty())
			throw new Exception("empty stack , wrong operation");
		int min = s.pop();
		int diff = s.pop();
		if(diff <=0){
			s.push(min - diff);
			return min;
		}else{
			if(!s.isEmpty()){
				s.push(min);
			}
			val = diff + min;
		}
		return val;
	}
	public int min(){
		return s.peek();
	}
	
	public static void main(String[] args) throws Exception{
		MinStack2 s = new MinStack2(); 
		s.push(3);
		s.push(4);
		s.push(2);
		s.push(5);
		s.push(1);
		s.push(1);
		s.push(6);
		s.push(7);
		System.out.println("min: "+ s.min());
		System.out.println(s.pop());
		System.out.println("min: "+ s.min());
		System.out.println(s.pop());
		System.out.println("min: "+ s.min());
		System.out.println(s.pop());
		System.out.println("min: "+ s.min());
		System.out.println(s.pop());
		System.out.println("min: "+ s.min());
		System.out.println(s.pop());
		System.out.println("min: "+ s.min());
		System.out.println(s.pop());
		System.out.println("min: "+ s.min());
		System.out.println(s.pop());
		System.out.println("min: "+ s.min());

		
	}
	
	
}
