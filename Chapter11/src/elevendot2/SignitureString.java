package elevendot2;

import sortingAlgorithms.Quicksort;

public class SignitureString implements Comparable<SignitureString>{
	private StringBuffer str;
	private StringBuffer signiture;
	
	
	
	public StringBuffer getStr() {
        return str;
	}

	public StringBuffer getSignatue() {
        return signiture;
	}

	public SignitureString(StringBuffer str){
        this.str = str;
        this.signiture = getSigniture(str);
	}

	private StringBuffer getSigniture(StringBuffer str2) {
		StringBuffer str = new StringBuffer(str2.toString().toLowerCase());
		Character[] arr = new Character[str.length()];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = new Character(str.charAt(i));
		}
		
		Quicksort<Character> qs = new Quicksort<Character>();
		qs.sort(arr);
		for(int i = 0; i < arr.length; i++){
            str.setCharAt(i, arr[i]);
		}
		
		return str;	
	}
	
	public int compareTo(SignitureString o){
		return this.signiture.toString().compareTo(o.signiture.toString());
	}
	
}