package eighteenthdot05;

public class ShortestDistance {

	
	public static int shortestDistance(String[] str, String word1, String word2){
		int lastIndexOfWord1 = -1;
		int lastIndexOfWord2 = -1;
		int shortestDistance = Integer.MAX_VALUE;
		for(int i = 0 ; i < str.length ; i++){
			int distance;
			String currentWord = str[i];
			if(currentWord.equals(word1)){
				lastIndexOfWord1 = i;
				if(lastIndexOfWord2 != -1){
					distance = i - lastIndexOfWord2;
					if(distance >=shortestDistance){
						distance = shortestDistance;
					}
				}
			}else if(currentWord.equals(word2)){
				lastIndexOfWord2 = i;
				if(lastIndexOfWord1 != -1){
					distance = i - lastIndexOfWord1;
					if(distance >=shortestDistance){
						distance = shortestDistance;
					}
				}
			}
			else{
				
			}
			
		}
		return shortestDistance;

	}
}
