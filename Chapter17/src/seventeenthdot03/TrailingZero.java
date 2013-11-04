package seventeenthdot03;

public class TrailingZero {
	public static void main(String[]args){
		int n = 12;
		System.out.println(trailingZeroNumber(n));
	}

	
	
	public static int trailingZeroNumber(int n){
		int i = 0;
		while(true){
			n = n / 5;
			if(n > 0){
				i++;
				continue;
			}
			break;
		}
		return i;
	}
}
