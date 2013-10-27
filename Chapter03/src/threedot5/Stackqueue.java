package threedot5;
/*
 * #career 3.5
#Implement a MyQueue class which implements a queue using two stacks.
#两个堆栈来回倒
#有用的链接：http://www.cnblogs.com/wanghui9072229/archive/2011/11/22/2259391.html

 */
import java.util.*;

public class Stackqueue {
	Deque<Integer> stack1 = new ArrayDeque<Integer>();
	Deque<Integer> stack2 = new ArrayDeque<Integer>();
	
	public void offer(int element){
		stack1.push(element);
	}
	
	public int pull(){
		if(stack2.isEmpty()){
			copyfromstac1tostack2();
		}
		
			return stack2.pop();
			
	}
	private void copyfromstac1tostack2(){
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
	}
	
	public static void main(String[]args){
		Stackqueue sq = new Stackqueue();
		for(int i = 0; i < 10 ; i++)
			sq.offer(i);
		for(int i = 0; i < 10 ; i++)
			System.out.println(sq.pull());
	}
}
