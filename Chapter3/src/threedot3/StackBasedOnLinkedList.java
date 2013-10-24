package threedot3;

class Node{
	int val;
	Node next;
	
	Node(int val){
		this.val = val;
	}
	
	void setNext(Node n){
		this.next = n;
	}
	
    Node getNext(){
		return this.next;
	}
	int getVal(){
		return this.val;
	}
	
}
public class StackBasedOnLinkedList {
	private int capacity;
	private Node top;
	private int size;
	
	public StackBasedOnLinkedList(int cap){
		this.capacity = cap;
	}
	
	public boolean isFull(){
		return size == capacity;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void push(int val) throws Exception{
		if(isFull())
			throw new Exception("full stack");
		Node n = new Node(val);
		n.setNext(top);
		this.top = n;
		size++;
	}
	public int pop() throws Exception{
		if(isEmpty())
			throw new Exception("empty stack");
		Node n = this.top;
		top = top.getNext();
		size--;
		return n.getVal();
	}
	public int peek(){
		return top.getVal();
	}
	public void clear(){
		top = null;
	}
	
	public int size(){
		return this.size;
	}

	
}
