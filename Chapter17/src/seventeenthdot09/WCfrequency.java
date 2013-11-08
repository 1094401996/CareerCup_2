package seventeenthdot09;
//another method is to build a hashmap 
public class WCfrequency {

	public static void main(String[] args) {
		String str = "   I am Geng Chen   \n";
		Result r = wc(str,"I");
		System.out.println(r.lines + "  " + r.words + "  " + r.chars   + " " + r.frequency);

	}
	
	
	public static Result wc(String book, String target){
		int i = 0 ; 
		int line = 0;
		int word = 0;
		int _char = 0;
		String str = "";
		int j = 0;
		boolean flag = false;//whether in word
		while(i < book.length()){
			char ch = book.charAt(i);
			_char++;
			if(ch == '\n'){
				line++;
			}else if(ch == ' ' || ch == '\t'){
				if(flag == true){
					word++;
					if(str.equals(target)){
						j++;
					}
					str = "";
					flag = false;
				}
			}else{
				flag = true;
				str = str + book.charAt(i);
			}
			i++;
		}
		
		return new Result(line,word,_char,(double)j/(double)word);
	}

}


class Result{
	int lines;
	int words;
	int chars;
	double frequency;
	
	Result(int lines, int words, int chars,double frequency){
		this.lines = lines;
		this.words = words;
		this.chars = chars;
		this.frequency = frequency;
	}
}
