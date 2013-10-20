package SLinkedList;

class Fu{
	int num = -1;
	Fu(){
		show1();
		return;
	}
	private void show1(){
		System.out.println("fu show");
	}
}
 class Zi extends Fu{
	int num = 1;
	{
		show();
		num = 2;
		
	}
	Zi(){
		super();
		show();
	}
	
	void show(){
		System.out.println("zi show" + num);
	}
	
}
 
 public class Test{
	 public static void main(String[] args){
		 Zi  z = new Zi();
//		 z.show();
	 }
 }
