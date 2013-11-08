package eighteenthdot07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestWord {

	public static void main(String[] args) {
		String[]arr ={"world","helloworld","hello","Chen","helloChen","cheat","helloworldChen"};
		
		System.out.println(printLongestWord(arr));
	}
	
	public static String printLongestWord(String[]arr){
		HashMap<String,Boolean> map = new HashMap<String,Boolean>();
		for(String str : arr){
			map.put(str, true);
		}
		Arrays.sort(arr,new LengthComparator());
		
		for(String s :arr){
			if(canBuildWord(s,true,map)){
				return s;
			}
		}
		return "";
	}
	
	
	private static boolean canBuildWord(String str, boolean isOriginalWord,HashMap<String,Boolean> map){
		if(map.containsKey(str) && !isOriginalWord){
			return map.get(str);
		}
		for(int i = 0;i < str.length();i++){
			String left = str.substring(0, i);
			String right = str.substring(i);
			if(map.containsKey(left) && map.get(left) == true && canBuildWord(right,false,map)){
				return true;
			}
		}
		map.put(str, false);
		return false;
		
	}

}



