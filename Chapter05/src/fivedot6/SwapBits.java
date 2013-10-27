package fivedot6;

public class SwapBits {
	
	
	public static void main(String[] args){
		System.out.println(Integer.toBinaryString(swap(10)));
	}
	
	public static  int swap(int num){
		return ((num & 0xaaaaaaaa) >> 1 )  | ((num & 0x55555555) << 1);
	}
}
