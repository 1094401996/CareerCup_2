package SLinkedList;

public class SLinkedList {
	private SNode head;
	private SNode tail;
	private int size;
	
	
	public SLinkedList(){
		
	}
	public SLinkedList(int[] vals){
		for(int i = 0; i < vals.length; i++){
			this.append(vals[i]);
		}
	}
	
	public void setHead(SNode head){
		this.head = head;
	}
	public SNode getHead(){
		return head;
	}
	
	
	public void setTail(SNode tail){
		this.tail = tail;
	}
	
	public SNode getTail(){
		return tail;
	}
	//add node to the tail
	
	public void append(int val){
		SNode s = new SNode(val,null);
		append(s);
	}
	public void append(SNode s){
		if(this.tail == null){
			this.setHead(s);
		}
		else tail.setNext(s);
		this.setTail(s);
		size++;
	}
	
	// add node to the head
	public void prepend(SNode s){
		if(head == null){
			this.setTail(s);
		}
		s.setNext(head);
		this.setHead(s);
		size++;
	}
	
	public void prepend(int val){
		SNode s = new SNode(val,head);
		prepend(s);
	}
	//delete the head
	public void deleteHead(){
		if(head == null){
			return ;
		}else
			head = head.getNext();
		
		size--;
	}
	
	//deleter the tail
	public void deleteTail(){
		if(tail == null){
			return ;
		}
		SNode s = head;
		while(s.getNext().getNext() != null){
			s = s.getNext();
		}
		s.setNext(null);
		tail = s;
		size--;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	
	public void printList(){
		if(head == null){
			return ;
		}
		SNode s = head;
		while(s != null){
			System.out.print(s.getVal()+ ",");
			s = s.getNext();
		}
		System.out.println();
	}
	
	public void deleterDup(){
		if(head == null || head.getNext()  == null)
			return;
		SNode prev = head;
		SNode curr = head.getNext();
		while(curr != null){
			SNode runner = head;
			while(runner != curr){
				if(curr.getVal() == runner.getVal()){
					runner.setVal(runner.getNext().getVal());
					runner.setNext(runner.getNext().getNext());
					size--;
					break;
				}
				runner = runner.getNext();
			}
			prev = curr;
			curr = curr.getNext();
		}
	}
	//know the size
	public SNode ithNodeFromTail1(int i){
		if(i >this.size)
			return null;
		SNode s = head;
		int k = size + 1 - i;
		for(int j = 1 ;j < k ; j++){
			s = s.getNext();
		}
		return s;
	}
	// size is unknown
	
	public SNode ithNodeFromTail2(int i){
		SNode f = this.head;
		SNode s = this.head;
		
		int j= 1;
		while(j != i){
			if(f == null){
				System.out.println("out of range");
				break;
			}
			f = f.getNext();
			j++;
		}
		if(f == null)
			return null;
		while(f.getNext() != null){
			f = f.getNext();
			s = s.getNext();
		}
		return s;
	}
	
	public SNode ithNodeFromTial3(int i){
		if (head == null){
			return null;
		}
		SNode curr = head;
		SNode next = head.getNext();
		curr.setNext(null);
		while(next !=null){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.setNext(temp);
		}
		int j = 1;
		SNode s = curr;
		while(j != i ){
			s = s.getNext();
			j++;
		}
		//恢复链表
		next = curr.getNext();
		curr.setNext(null);
		while(next!=null){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.setNext(temp);
		}
		return s;
	}
	
	public void deleterMiddleNode(SNode s){
		if(s == null || s.getNext() == null){
			return;
		}
		s.setVal(s.getNext().getVal());
		s.setNext(s.getNext().getNext());
	}
	
	public void partitionList(int val){
		if(this.size < 2){
			return;
		}
		SNode prev = new SNode();
		prev.setNext(head);
		SNode curr = head;
		while(curr!=null){
			if(curr.getVal() < val){
				int temp;
				prev = prev.getNext();
				temp = curr.getVal();
				curr.setVal(prev.getVal());
				prev.setVal(temp);
			}
			curr = curr.getNext();
		}
	}
	public static void main(String[]args){
		int[] vals = {1,2,3,4,5};
		SLinkedList sl = new SLinkedList(vals);
		sl.printList();
	}
}
