package fivedot3;

public class NextNumber {
	
	
	public static void main(String[]args){
		int num = 13948;
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(getNextBigger(num)));
		System.out.println(Integer.toBinaryString(getNextSmaller(num)));
	}
	public static int getNextBigger(int num){
		int c = num; 
		int c0 =0; 
		int c1 = 0;
		
		while((c & 1) == 0 && c != 0){
			c0++;
			c >>= 1;
		}
		while((c & 1) == 1){
			c1++;
			c >>= 1;
		}
		System.out.println(c1);
		if(c0 + c1 == 31 || c0 + c1 == 0)
			return -1;
		
		int p = c0 + c1;
		num |=(1 << p);
		num =helper.BitTool.clearBitsFromITo0(num, p-1);
		num |= ((1<<(c1 - 1)) -1);
		return num;
	}
	
	public static int getNextSmaller(int num){
		
		int c0 = 0;
		int c1 = 0;
		int c = num;
		while((c & 1) == 1){
			c1++;
			c = (c >> 1);
		}
		if(c == 0)
			return -1;
		while((c & 1) == 0 && c!=0){
			c0++;
			c = (c>>1);
		}
		int p = c0 + c1;
		num = helper.BitTool.clearBitsFromITo0(num, p);
		int mask = (1<<(c1+1)) -1 ;
		num |= mask << (c0 - 1);
		
		return num;
	}
}


