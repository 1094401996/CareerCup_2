package seventeenthdot01;

public class SwapNum {
	public static void main(String[]args){
		int a = 2; 
		int b = 3;
		
		
		a = b - a;
		b = b - a;
		a = a + b;
		
		System.out.println("a , b  " + a + "  " + b);
		
		
		a = a ^ b;
		b = a ^ b; 
		a = a ^ b;
		
		System.out.println("a , b  " + a + "  " + b);

	}
	
}
