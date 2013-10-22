package fivedot5;

public class ConvertInteger {
	
	public static void main(String[]args){
		System.out.println(get1Bits1(31,14));
		System.out.println(get1Bits2(31,14));
	}
	
	
	
	
	
	public static int get1Bits1(int num1, int num2){
		int num = num1 ^ num2;
		int count = 0;
		while(num!=0){
			count += (num & 1);
			num >>=1;
		}
		return count;
	}
	
	public static int get1Bits2(int num1, int num2){
		int num = num1 ^ num2;
		int count = 0;
		while(num!=0){
			num = num & (num - 1);
			count++;
		}
		return count;
	}}
