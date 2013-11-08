package eighteenthdot03;

import java.util.Arrays;

/*
 * write a method to randomly generate a set of m integers form a array of size n,.Each element
 * must have equal probability of being chose;
 */
public class RandomSet {
	
	public static void main(String[]args){
		int[]original = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(randomset(original,3)));
	}
	
	public static int[] randomset(int[]original, int m){
		int[]clone = original.clone();
		int[]subset = new int[m];
//		System.out.println(Arrays.toString(clone));
		
		for(int i = 0 ; i < m; i++){
			int temp;
			int index  = rand(i,clone.length - 1);
			System.out.println(index);
			subset[i] = clone[index];
			clone[index] = clone[i];
			
			
		}
		
		return subset;
		
	}
	
	private static int rand(int low, int high){
		return low + (int)(Math.random() * (high - low + 1)) ;
		
	}

}
