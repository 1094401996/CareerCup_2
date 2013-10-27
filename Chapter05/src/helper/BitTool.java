package helper;

public class BitTool {
	//get the bit
	public static boolean getBit (int num ,int i){
		return (num & (1 << i)) == 0;
	}
	
	//set the bit
	public static int setBit(int num, int i){
		return num | (1 << i);
	}
	//clear the bit
	public static int clearBit(int num , int i){
		return num & (~(1 << i));
	}

	//clear clear bits from the most significant bit to i
	public static int clearBitsFromMSToI(int num, int i){
		return num & (~(1<<i - 1));
	}
	
	//clear bits form the i to 0
	public static int clearBitsFromITo0(int num, int i){
		int mask = ~((1 << (i + 1)) - 1);
		return mask & num;
	}
	//update bit 
	public static int update (int num, int i, int val){
		num = clearBit(num,i);
		return num | (val<<i);
		
	}
	
}
