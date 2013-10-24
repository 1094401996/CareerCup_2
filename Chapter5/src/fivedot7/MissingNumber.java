package fivedot7;

import java.util.ArrayList;

/**
 * CareerCup 5.7 
 * An array A contains all the integers from 0 to n, except for one number which is missing. 
 * In this problem, we cannot access an entire integer in A with a single operation. The elements
 * of A are represented in binary, and the only operation we can use to access them is "fetch the
 * jth bit of A," which takes constant time. Write code to find the missing integer. Can you do 
 * it in O(n) time?
 * useful link:http://www.cnblogs.com/shilcare/archive/2012/04/24/2468084.html
 */


public class MissingNumber {
	
	public static void main(String[] args){
        ArrayList<String> A = new ArrayList<String>();
        A.add("000");
        A.add("001");
        A.add("010");
        A.add("011");
        A.add("100");
        A.add("101");
        A.add("111");
        
        int m = findMissing(A);
        System.out.println(Integer.toBinaryString(m));
        
	}
	public  static  int findMissing(ArrayList<String> array){
        int k = array.get(0).length();
        return findMissing(array, k - 1);
}

	
	public static int findMissing(ArrayList<String>input, int i){
		if(i < 0)
			return 0;
		
		
		ArrayList<String> zeros = new ArrayList<String>();
        ArrayList<String> ones = new ArrayList<String>();
        for(String integer : input){
			if(integer.charAt(i) == '0'){
                    zeros.add(integer);
            }
            else if(integer.charAt(i) == '1'){
                    ones.add(integer);
            }else{
                    System.out.println("wrong input");
                    System.exit(-1);
            }
        }
            if(zeros.size() <= ones.size()){
            	int v = findMissing(zeros, i - 1);
            	return (v<<1) |0;
            }else{
            	int v = findMissing(ones,i - 1);
            	return (v << 1) | 1;
            }
        }

}
