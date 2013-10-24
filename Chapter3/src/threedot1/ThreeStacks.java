package threedot1;
/*
 *Career 3.1 
 * Describe how you could use a single array to implement three stacks.
 */

public class ThreeStacks {
	private int stackSize =  10;
	private int[]array = new int[30];
	private int[]points = {0,0,0};
	
	public ThreeStacks(){
		
	}
	
	public ThreeStacks(int stackSize){
		this.stackSize = stackSize;
		array = new int[3*stackSize];
	}
	
	public int peek(int num) throws Exception{
		if(this.isEmpty(num))
			throw new Exception("empty stack");
		return array[getIndex(num)];
			
		
	}
	
	public boolean isEmpty(int num){
		if(points[num] == 0)
			return true;
		return false;
	}
	public boolean isFull(int num){
		if(points[num] == stackSize)
			return true;
		return false;
	}
	public void push(int num , int element) throws Exception{
		if(this.isFull(num))
			throw new Exception("full stack");
		array[getIndex(num)] = element;
		points[num]++;
	}
	public int pop(int num) throws Exception{
		if(this.isEmpty(num))
			throw new Exception("empty stack");
		points[num]--;
		int val = array[getIndex(num)];
		return val;
	}
	private int getIndex(int num){
		return num * stackSize + points[num];
	}
	
	public static void main(String[]args) throws Exception{
		ThreeStacks ts = new ThreeStacks();
        for(int i = 1 ; i <= 10 ; i++){
                ts.push(1, i);
        }
        for(int i = 0; i < 10; i++){
                System.out.print(ts.pop(1) + " ");
        }
	}

}
