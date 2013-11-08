package eighteenthdot08;

import java.util.ArrayList;

/**
 * Give a string s, and an array of smaller string T, design a method to search s for each small string
 * in T
 * @author gengchen
 *
 */
public class SearchString {
	
	public static void main(String[]args){
		String str = "helloworldFromChen";
		SuffixTree st = new SuffixTree(str);
		String small = "Chen";
		ArrayList<Integer> al = st.search(small);
		
		for(Integer i : al){
			System.out.print(i + "  ");
		}
		
	}

}
