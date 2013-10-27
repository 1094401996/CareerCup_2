package onedot1;

import java.util.HashMap;
import java.util.Map;

/*
 * three methods
 * 1,bitmap
 * 2,hashmap
 * 3,quicksort
 */

public class UniqueCharacter {
	public static void main(String[]args){
		StringBuffer[] strArray  = {new StringBuffer("abcdefegd"),new StringBuffer("gfedcba"),new StringBuffer("c")};
		for(StringBuffer str : strArray)
			System.out.println(isUnique1(str));
		for(StringBuffer str :strArray){
			System.out.println(isUnique2(str));
		}
		for(StringBuffer str :strArray){
			System.out.println(isUnique3(str));
		}
		
	}
	//method 1: bitmap
	public static boolean isUnique1(StringBuffer str){
		boolean []bitmap = new boolean[256];
		for(int i = 0; i < 256; ++i){
			bitmap[i] = false;
		}
		int len = str.length();
		for(int j = 0 ; j < len; j++){
			int Val = str.charAt(j);
			if(bitmap[Val] == true){
				return false;
			}
			else
				bitmap[Val] = true;
		}
		return true;
	}
	
	//method 2:hashmap
	public static boolean isUnique2(StringBuffer str){
		Map<Character, Boolean> charMap = new HashMap<Character, Boolean>();
		int len = str.length();
		for(int i = 0 ; i < len; i++){
			if(charMap.containsKey(str.charAt(i)))
				return false;
			else
				charMap.put(str.charAt(i), true);
		}
		return true;
		
	}
	
	//method 3 : quicksort
	public static boolean isUnique3(StringBuffer str){
		 int len = str.length();
		 quicksort(str,0,len - 1);
		 for(int i = 0; i < len - 1; i++){
			 if(str.charAt(i) == str.charAt(i + 1)){
				 return false;
			 }
			
		 }
		 return true;
		
	}
	
	private static void quicksort(StringBuffer str, int left, int right){
		if (left < right){
			int pivotIndex = partition(str,left, right);
			quicksort(str,left,pivotIndex - 1);
			quicksort(str,pivotIndex + 1, right);
		}
	}
	private static int partition(StringBuffer str, int left, int right){
		int pivot = str.charAt(right);
		int i = left - 1;
		for(int j = left; j < right; j++){
			if(str.charAt(j) <=pivot){
				char temp = str.charAt(++i);
				str.setCharAt(i, str.charAt(j));
				str.setCharAt(j, temp);
			}
		}
		char temp = str.charAt(++i);
		str.setCharAt(i, str.charAt(right));
		str.setCharAt(right, temp);
		return i;
	}
	
}
