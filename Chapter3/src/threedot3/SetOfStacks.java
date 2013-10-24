package threedot3;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 *  Therefore, in real life, we would likely start a new stack when the previous stack 
 *  exceeds some threshold. Implement a data structure SetOfStacks that mimics this. 
 *  SetOfStacks should be composed of several stacks and should create a new stack once the 
 *  previous one exceeds capacity.SetOfStacks.push() and SetOfStacks.pop() should behave identically 
 *  to a single stack (that is, pop() should return the same values as it would if there were just a 
 *  single stack).
 *  
 *  
 *  
 *  FOLLOW UP
 *  Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 */

import java.util.ArrayList;

public class SetOfStacks {
	private ArrayList<StackBasedOnLinkedList> stacks = new ArrayList<StackBasedOnLinkedList>();
	private int cap ;
	
	public SetOfStacks(int cap){
		this.cap = cap;
	}
	
	
	public void push(int val) throws Exception{
		StackBasedOnLinkedList last = getLastStack();
		if(last != null && ! last.isFull()){
			last.push(val);
		}else{
			StackBasedOnLinkedList stack = new StackBasedOnLinkedList(cap);
			stacks.add(stack);
			stack.push(val);
		}
		
	}
	
	public int pop() throws Exception{
		StackBasedOnLinkedList last = getLastStack();
		int v = last.pop();
		if(last.size() == 0)
			stacks.remove(stacks.size() - 1);
		return v;
	}
	
	public int popAt(int index) throws Exception{
		if(index > stacks.size() - 1)
			throw new Exception("out of index range");
		StackBasedOnLinkedList stack = stacks.get(index);
		int val = stack.pop();
		if(stack.isEmpty())
			stacks.remove(index);
		return val;
	}
	
	private StackBasedOnLinkedList getLastStack(){
		if(stacks.size() == 0)
			return null;
		return stacks.get(stacks.size() - 1);
	}
	
	public static void main(String[] args) throws Exception{
		SetOfStacks  setstack= new SetOfStacks(5);
		for(int i = 0 ; i < 15; i++)
			setstack.push(i);
		for(int i = 0 ; i < 5 ; i ++)
			System.out.print(setstack.popAt(1)+ " ");
		System.out.println(setstack.popAt(1));
		
	}
}
