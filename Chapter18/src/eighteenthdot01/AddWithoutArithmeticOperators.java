package eighteenthdot01;
/*
 * write a method that adds two numbers, you should not use any arithmetic oprators
 */
public class AddWithoutArithmeticOperators {

	public static void main(String[]args){
		System.out.println(add(3,5));
	}
	
	public static int add(int a, int b){
		if( b == 0)
			return a;
		
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return add(sum,carry);
	}
}
