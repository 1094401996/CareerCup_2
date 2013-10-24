package threedot2;

public class MinStack {
	private Stack s;
	private Stack helper;
	public MinStack(int cap){
		s = new Stack(cap);
		helper = new Stack(cap);
	}
	
	public boolean isEmpty(){
		return s.isEmpty();
	}
	public int size(){
		return s.size();
	}
	public boolean isFull(){
		return s.isFull();
	}
	public int peek() throws Exception{
		return s.peek();
	}
	
	public void push(int data) throws Exception{
		if(!s.isFull())
			s.push(data);
		if(helper.isEmpty()){
			helper.push(data);
			return;
		}
		int val = helper.peek();
		if(val >= data)
			helper.push(data);
		
	}
	public int pop() throws Exception{
		int val;
		if(s.isEmpty())
			throw new Exception("empty stack");
		val = s.pop();
		if(helper.peek() == val)
			helper.pop();
		return val;
			
	}
	public int min() throws Exception{
		return helper.peek();
	}
	public static void main(String[]args) throws Exception{
        MinStack s = new MinStack(100);
        s.push(3);
        s.push(2);
        s.push(5);
        s.push(4);
        s.push(1);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
	}
}



class Stack {
    private int[] a;
    private int N;
    public Stack (int cap){
            a = new int[cap] ;
            }
    public boolean isEmpty(){
            return N == 0;
    }
    public boolean isFull(){
    	return N == a.length;
    }
    public int size(){
            return N;
    }
    public void push(int data){
            a[N++] = data;
    }
    public int pop(){
            return a[--N];
    }
    public int peek() throws Exception{
            if (!isEmpty()){
                    return a[N - 1];
            }
            throw new Exception("empty stack");
    }
    public void clear(){
            N = 0;
    }
}