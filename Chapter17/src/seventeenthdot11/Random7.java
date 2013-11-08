package seventeenthdot11;

import java.util.Random;

public class Random7 {
	public static void main(String[]args){
		System.out.println(rand7());
	}

	
	public static int rand7(){
		Random r = new Random();

		while(true){
			
			int num = 5 * r.nextInt(5) + r.nextInt(5);
			if(num < 21){
				return num % 7;
			}
		}
		
		
		
	}
}
