package SLinkedList;

public class SNode {
	private int val;
    SNode next;
	
	public SNode(){
		
	}
	
	public SNode(int val){
		this.val = val;
	}
	
	public SNode(int val, SNode next){
		this.val = val;
		this.next = next;
	}
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public SNode getNext() {
		return next;
	}

	public void setNext(SNode next) {
		this.next = next;
	}

	

}
