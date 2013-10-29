package elevendot5;

public class findString {
	
	public static void main(String[]args){
        
        String[] strs={"at","","","","","ball","","","car","cat","","dad","","","hello"};
        String target = "at";
        System.out.println(findString(strs,target,0,strs.length - 1));
	}
	
	
    public static int findString(String[] strs, String target,int left, int right){
    
    	if(right >= left){
    		int mid = (left + right) /2;
    		if(strs[mid].isEmpty()){
    			//find the closest non-empty string
    			int leftindex = mid - 1;
    			int rightindex = mid + 1;
    			while(true){
    				if(leftindex < left && rightindex > right){
    					return -1;
    				}else if(rightindex <= right &&!strs[rightindex].isEmpty()){
    					mid = rightindex;
    					break;
    				}else if(leftindex >= left && !strs[leftindex].isEmpty()){
    					mid = leftindex;
    					break;
    				}
    				rightindex++;
    				leftindex--;
    			}
    		}
    		int result = strs[mid].compareTo(target);
    		if(result == 0)
    			return mid;
    		else if( result > 0){
    			return findString(strs,target,left,mid - 1);
    		}else{
    			return findString(strs,target,mid + 1, right);
    		}
    	}
    	return -1;

    }
}
