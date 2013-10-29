package elevendot2;
import sortingAlgorithms.Quicksort;
/**
 * CareerCup11.2
 *  write a method to sort an array of strings so that all the anagrams are next to each
 * @author gengchen
 *
 */

public class AnagramSort {
	 public static void main (String[] args){
         
         StringBuffer[] str = {
                                       new StringBuffer("lhep"),
                                                     new StringBuffer("abc"),
                                                   new StringBuffer("elpH"),
                                                   new StringBuffer("cba"),
                                                   new StringBuffer("help"),
                                                   new StringBuffer("Bca"),
                   
         };
         
         SignitureString[] ss = new SignitureString[str.length];
         for(int i = 0 ; i < str.length; i ++){
                 ss[i] = new SignitureString(str[i]);
         }
         Quicksort<SignitureString> qs = new Quicksort<SignitureString>();
         qs.sort(ss);
         for(SignitureString sig : ss){
                 System.out.print(sig.getStr() + " ");
         }
         
 }
	
}
