package fivedot1;

public class InsertBit {
	public static void main(String[] args) throws Exception{
        int N = 1024;
        int M = 19;
        int N1 = insertBits(N,M,2,6);
        System.out.println("N = " + Integer.toBinaryString(N) + ", M = " + Integer.toBinaryString(M) + ", after the insertion, N becaomes " + Integer.toBinaryString(N1));
        System.out.println(Integer.toBinaryString(-2147483648));
	}
	
	private static int insertBits(int N, int M, int i , int j) throws Exception{
		int size = Integer.toBinaryString(M).length();
		if(j - i + 1 < size){
			throw new Exception("no enough space");
		}
		
		int mask1 =  ~ ((1 << (j + 1)) - 1);
		int mask2 = (1 << (i + 1)) -1;
		int mask = mask1 | mask2;
		int num = N & mask;
		
		return num | (M <<i);
	}
}
