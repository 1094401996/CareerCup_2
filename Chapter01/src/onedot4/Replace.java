package onedot4;

public class Replace {

	public static void main(String[] args) {
		char[] str = "d f  d         ".toCharArray();
		replace(str,4);
		int i = 0;
		while(str[i] !='\0'){
			System.out.print(str[i]);
			i++;
			}
		}
		
	
	public static void replace(char[]str,int len){
		int spacenum = 0;
		for(int i = 0;i <len ; i++){
			if(str[i] == ' '){
				spacenum++;
			}
		}
		int newlen = len + 2*spacenum;
		str[newlen] = '\0';
		int k = newlen - 1;
		for(int i = len - 1; i >=0; i--){
			if(str[i] == ' '){
				str[k--] = '0';
				str[k--] = '2';
				str[k--] ='%';
			}
			else
				str[k--] = str[i];
		}
		
	}

}
