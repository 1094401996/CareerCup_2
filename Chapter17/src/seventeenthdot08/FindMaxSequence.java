package seventeenthdot08;

public class FindMaxSequence {
	
	public static void main(String[]args){
		int[]data = {2,-8,3,-2,4,-10};
		
		Result r = findMaxSequence(0,data.length - 1, data);
		System.out.println("left: " + r.left + "  right: " + r.right + " sum: " + r.sum);
	}

	
	public static Result findMaxSequence(int left, int right,int[]data){
		
		if(left ==right){
			return new Result(left,right,data[left]);
		}
		int mid = (left + right)/2;
		Result rl = findMaxSequence(left,mid,data);
		Result rr = findMaxSequence(mid + 1,right,data);
		Result rm = findCross(left,right,data);
		
		if(rl.compareTo(rr) >= 0){
			return (rl.compareTo(rm) > 0) ? rl :rm;
		}else{ 
			return (rr.compareTo(rm) > 0) ? rr :rm;
		}
		
		
	}

	private static Result findCross(int left, int right, int[] data) {
		int leftsum = Integer.MIN_VALUE;
		int mid = (left + right)/2;
		int sum = 0;
		int low = mid;
		for(int i = mid; i >= left; i--){
			if((sum+=data[i]) >= leftsum){
				leftsum = sum;
				low = i;
			}
		}
		int high = mid + 1;
		sum = 0;
		int rightsum = Integer.MIN_VALUE;
		for(int j = mid + 1; j <= right; j++){
			if((sum+=data[j]) >=rightsum){
				rightsum = sum;
				high = j;
			}
		}
		
		return new Result(low,high,leftsum + rightsum);
	
	}
	
	
}

class Result implements Comparable<Result>{
	int left;
	int right;
	int sum;
	
	Result(){
		
	}
	Result(int left, int right, int sum){
		this.left = left;
		this.right = right;
		this.sum = sum;
	}
	@Override
	public int compareTo(Result r) {
		
		return this.sum - r.sum;
	}
}
