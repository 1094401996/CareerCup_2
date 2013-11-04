package seventeenthdot04;

public class FindMaximun {
	
	public static void main(String[]args){
		
		System.out.println(getMax(23,-24));
		
		
	}
	
	public static int getMax(int a, int b){

		int c = a - b;
		
		int as = sign(a);
		int bs = sign(b);
		int cs = sign(c);
		
		//if a and b have different sign bit
		int a_in_use = as ^ bs;
		
		int c_in_use = flip(as^bs);
				
		int k = a_in_use * as + c_in_use * cs;
				
		return a *k + b*flip(k);
	}
	
	private static int flip(int i){
		return i ^ 1;
	}
	//return 1 if a is positive , or return 0
	private static int sign(int a){
		return flip((a >> 31) & 1);
	}
	
}




