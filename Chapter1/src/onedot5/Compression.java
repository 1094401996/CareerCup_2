package onedot5;

public class Compression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strArray = {"abcdfg","aaaadfdfdfffffnnnnn"};
		for(String eachstr : strArray){
			System.out.println(compress(eachstr));
		}

	}
	private static String compress(String str){
		if(!isFeasible(str)){
			System.out.println("no need to compress");
			return str;
		}
		StringBuffer mystr = new StringBuffer();
		char flag = str.charAt(0);
		int count = 1;
		for(int i = 1 ; i < str.length(); i++){
			if(str.charAt(i) == flag){
				count++;
			}else{
				mystr.append(flag);
				mystr.append(count);
				flag = str.charAt(i);
				count = 1;
			}
		}
		mystr.append(flag);
		mystr.append(count);
		return mystr.toString();
		
		
	}
	private static boolean isFeasible(String str){
		int newlen = 0;
		char flag = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length();i++){
			if(str.charAt(i) == flag){
				count++;
			}
			else{
				flag = str.charAt(i);
				newlen += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		newlen += 1 + String.valueOf(count).length();
		return str.length() > newlen;
	}

}
