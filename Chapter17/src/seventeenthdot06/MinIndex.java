package seventeenthdot06;

public class MinIndex {
	
	
	public static void main(String[]args){
		int[]array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
		Result r = MinIndex.findUnsortedSequence(array);
		System.out.println(r.left + "  " + r.right);
	}
	
	
	public static int findEndOfLeftSubsequence(int[]array){
		for(int i = 1 ; i < array.length ; i++){
			if(array[i] < array[i - 1])
				return i - 1;
			
		}
		return array.length - 1;
	}
	
	public static int findStartOfRightSubsequence(int[]array){
		for(int i = array.length - 2; i >=0; i-- ){
			if(array[i] > array[i + 1])
				return i + 1;
		}
		return 0;
	}
	
	public static int shinkLeft(int[]array,int min_index, int start){
		int comp = array[min_index];
		for(int i = start - 1; i>= 0; i--){
			if(array[i]<=comp){
				return i + 1;
			}
		}
		
		return 0;
	}
	
	public static int shinkRight(int[]array,int max_index, int start){
		int comp = array[max_index];
		for(int i = start; i< array.length; i++){
			if(array[i] >= comp){
				return i - 1;
			}
		}
		
		return array.length - 1;
	}
	
	public static Result findUnsortedSequence(int[]array){
		int end_left = MinIndex.findEndOfLeftSubsequence(array);
		int start_right = MinIndex.findStartOfRightSubsequence(array);
		
		
		int min_index = end_left + 1;
		if(min_index >= array.length){
			return new Result(0,array.length - 1);
		}
		
		int max_index = start_right - 1;
		for(int i = end_left; i<=start_right; i++){
			if(array[i] < array[min_index]){
				min_index = i;
			}
			if(array[i] > array[max_index])
				max_index = i;
		}
		
		//slide left until less than array[min_Index]
		
		int left_index = MinIndex.shinkLeft(array, min_index, end_left);
		
		//slide right until greater than array[max_index]
		
		int right_index = MinIndex.shinkRight(array, max_index, start_right);
		
		return new Result(left_index,right_index);
		
	}
	
	

}


class Result{
	int left;
	int right;
	Result(int left, int right){
		this.left = left;
		this.right = right;
	}
}
