package elevendot3;

public class BinarySearchVariant {
	/**
	 * Given a sorted array of n integers that has been rotated an unknown number of times, 
	 * give an O(log n) algorithm that finds an element in the array. You may assume that the
	 *  array was originally sorted in increasing order. 
	 *  EXAMPLE:
	 *  Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
	 *  Output: 8 ( the index of 5 in the array)
	 * @author gengchen
	 * 
	 */
	
	
	public static void main(String[] args){
        int[] data={2,2,2,3,4,2};
        System.out.println(findTarget(data,2,0,data.length - 1));
	}
	
	
	public static int findTarget(int[]data ,int target, int left, int right){
		if(left > right)
			return -1;
		
		int mid = (left + right) /2;
		if(data[mid] == target){
			return mid;
		}
		
		if(data[mid] > data[left]){
			if(target >= data[left] && target <data[mid]){
				return findTarget(data,target,left,mid - 1);
			}else{
				return findTarget(data,target,mid + 1, right);
			}
		}else if(data[mid] < data[left]){ //the right part is normally ordered
		
			if(target<=data[right] &&target > data[mid]){
				return findTarget(data,target,mid + 1, right);
			}else{
				return findTarget(data,target,left,mid - 1);
			}
		}else if(data[mid] == data[left]){ 
			if(data[mid] != data[right]){ //当mid!= right，我们能够确定左半边都是相同元素，只需搜索左边，但当mid=right时，两边都有可能全是相同元素，所以必须都搜索
				return findTarget(data,target,mid + 1,right);
			}else{ //else we have to search both sides
				int result = findTarget(data,target,left, mid - 1);
				if(result == -1){
					return findTarget(data,target,mid + 1, right);
				}else{
					return result;
				}
			}
		}
			return -1;
	}

}
