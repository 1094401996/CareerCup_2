package seventeenthdot07;

import java.nio.ShortBuffer;

public class printNumber {
	public static String[] unit = {"","thousand","milition","billion"};
	public static String[] _1to9 = {"one","two","three","four","five","six","seven","eight","nine"};
	public static String[] _11to19 = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	public static String[] _10to90 = {"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		StringBuffer str = new StringBuffer();
		System.out.println(print(1225,str));
		
	}
	
	

	
	
	public static StringBuffer print(int num,StringBuffer str){
		if(num == 0){
			return new StringBuffer("zero");
		}
		if(num <0 ){
			return print(-num,str).insert(0, "negative ");
		}
		int count = 0 ; 
		while(num > 0){
			int remainder = num% 1000;
			if(remainder != 0){
				str = new StringBuffer(numtoString(remainder) + unit[count] + " " + str);
			}
			num = num / 1000;
			count++;
		}
		
		return str;
		
	}
	
	private static String numtoString(int num) {
		String str = "";
		//convert hundreds place
		
		
		if(num >= 100){
			str += _1to9[num/100 - 1] + " Hundred ";
			num %= 100; 
		}
		
		//convert tens place
		if(num >= 11 && num <= 19){
			return str + _11to19[num - 1] + " ";
		}else if(num == 10 || num >= 20){
			str += _10to90[num / 10 - 1] + " ";
			num %= 10;
		}
		
		//convert ones place
		
		if(num >= 1 && num <= 9){
			str += _1to9[num - 1] + " ";
		}
		
		return str;
	
	}

}
