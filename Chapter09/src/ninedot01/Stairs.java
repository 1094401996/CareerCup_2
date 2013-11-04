/*
 * Careercup 9.1
 * a child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3
 * steps at a time, implement a method to count how many ways the child can run up the stares
 * 
 * DP
 */

package ninedot01;

public class Stairs {
	public static int[] count = new int[100];
	
	public static void main(String[]args){
	
		System.out.println(countWays(4,count));
		System.out.println(countWays(0,count));
		System.out.println(countWays(1,count));
		System.out.println(countWays(2,count));
		System.out.println(countWays(3,count));
		

	}
	
	public static int countWays(int n , int[]count){
		if(n <= 0){
			return 0;
		}else if( n == 1){
			return 1 ;
		}else if(n == 2){
			return 2;
		}else if(count[n] != 0){
			return count[n];
		}
		else{
			count[n] = countWays(n - 1,count) + countWays(n - 2,count) + countWays(n - 3,count);
			return count[n];
		}
	}
}
