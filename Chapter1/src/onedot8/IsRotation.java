package onedot8;

public class IsRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer str1 = new StringBuffer("abcdef");
		StringBuffer str2 = new StringBuffer("cdefgf");
		System.out.println(isRotation(str1,str2));

	}
	
	
	public static boolean isRotation(StringBuffer str1 , StringBuffer str2){
		if(str1.length() != str2.length()){
			return false;
		}
		StringBuffer newString = str1.append(str1);
		return isSubString(newString, str2);
	}
	
	private static boolean isSubString(StringBuffer str1, StringBuffer str2){
		int len1 = str1.length();
		int len2 = str2.length();
		
		for(int start = 0; start <= len1 - len2; start++){
			int i = start;
			for(int j = 0; j < str2.length(); j++){
				if(str1.charAt(i) == str2.charAt(j)){
					if(j == str2.length() - 1)
						return true;
					i++;
				}else
					break;
			}
			
		}
		
		return false;
	}

}
