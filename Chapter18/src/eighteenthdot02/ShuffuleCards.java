package eighteenthdot02;

import java.util.Arrays;

/*
 * write a method to shuffle a deck of cards, It must be a perfect card, in other word,each of the 52!
 * permutations of the deck has to be equally likely,Assume that you are given a random number generator
 * which is perfect
 */

public class ShuffuleCards {
	
	public static void main(String[]args){
		int[]data = new int[52];
		for(int i = 0; i < data.length; i++){
			data[i] = i;
		}
		shuffle(data);
		System.out.println(Arrays.toString(data));
	}
	
	
	public static void shuffle(int cards[]){
		int temp , index;
		for(int i = 0 ; i < cards.length ; i ++){
			index = (int)(Math.random() * (cards.length - i)) + i;
			temp = cards[i];
			cards[i] = cards[index];
			cards[index] = temp;
		}
	}
}
