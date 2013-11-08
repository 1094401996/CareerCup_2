package eighteenthdot04;
/*
 * write a method to count the number of 2s that appear in all the numbers between 0 and N(inclsive
 * 22 counts for two 2s
 */
public class Count2s {

	public static void main(String[]args){
		System.out.println(Count2s.count2sInRange(25));
	}
	public static int count2sInRangeAtDigit(int number , int d){
		int powerof10 = (int)Math.pow(10, d);
		int nextpowerof10 = powerof10 * 10;
		int right = number % powerof10;
		
		int roundDown = number - number % nextpowerof10;
		int roundUp = roundDown + nextpowerof10;
		
		int digit = (number /powerof10) % 10;
		if(digit < 2){
			return roundDown / 10;
		}else if (digit > 2){
			return roundUp / 10;
		}else{
			return roundDown / 10 + right + 1;
		}
	}
	
	public static int count2sInRange(int number){
		int count = 0;
		int len = String.valueOf(number).length();
		for(int digit = 0 ; digit < len; digit++){
			count += count2sInRangeAtDigit(number,digit);
		}
		return count;
	}
}
