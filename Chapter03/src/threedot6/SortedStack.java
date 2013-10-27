package threedot6;

import java.util.ArrayDeque;

public class SortedStack {
	
	public static void main(String[]args){
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		
			stack.push(1);
			stack.push(10);
			stack.push(9);
			stack.push(6);
			stack.push(15);
			stack.push(5);
		stack = sort(stack);

		while(!stack.isEmpty())
			System.out.println(stack.pop());
	}
	
	public static ArrayDeque<Integer> sort(ArrayDeque<Integer> stack){
		ArrayDeque<Integer> stackhelper = new ArrayDeque<Integer>(stack.size());
		while(!stack.isEmpty()){
			int temp = stack.pop();
			while(!stackhelper.isEmpty() && temp < stackhelper.peek()){
				stack.push(stackhelper.pop());
			}
			stackhelper.push(temp);
		}
		return stackhelper;
	}
}
