package eighteenthdot10;

/*
 * Given two words of equal length that are in a dictionary, write a method to transform
 * one word into another word by changing only one letter at a time. The new word you get
 * in each step must be in the dictionary
 * 
 * Example 
 * Input : DAMP,LIKE
 * DAMP -> LAMP -> LIMP -> LIME -> LIKE
 * 
 */
import java.util.*;

public class TransformWord {
	public static void main(String[]args){
		Set<String> dictionary = new TreeSet<String>();
		dictionary.add("DAMP");
		dictionary.add("LAMP");
		dictionary.add("LIMP");
		dictionary.add("LIME");
		dictionary.add("LIKE");
		String startword = "DAMP";
		String endword = "LIKE";
		TransformWord tw = new TransformWord();
		LinkedList<String> path = tw.transform(startword,endword,dictionary);
		for(String str : path){
			System.out.print(str +"-> ");
		}
				
		
	
	}

	LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary){
		
		startWord = startWord.toUpperCase();
		stopWord = stopWord.toUpperCase();
		
		Queue<String>actionQueue = new LinkedList<String>();
		Set<String>visitedSet = new HashSet<String>();
		Map<String, String> backtrackMap = new TreeMap<String,String>();
		
		actionQueue.offer(startWord);
		visitedSet.add(startWord);
		while(!actionQueue.isEmpty() ){
			String w = actionQueue.poll();
			for(String v :getOneEditWords(w)){
				if(v.equals(stopWord)){
					LinkedList<String> list = new LinkedList<String>();
					list.add(v);
					while(w != null){
						list.add(0,w);
						w = backtrackMap.get(w);
					}
					return list;
				}
				if(dictionary.contains(v)){
					if(!visitedSet.contains(v)){
						actionQueue.add(v);
						visitedSet.add(v);
						backtrackMap.put(v, w);
					}
				}
			}
			
		}
//		System.out.println("dfdasf");
		return null;
		
		
	}

	
	Set<String> getOneEditWords(String word){
		Set<String> words = new TreeSet<String>();
		for(int i = 0 ; i < word.length(); i++){
			char[]wordArray = word.toCharArray();
			for(char c ='A'; c <='Z'; c++){
				if(c!=word.charAt(i)){
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
			}
		}
		
		return words;
	}
}
