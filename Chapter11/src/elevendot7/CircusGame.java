/**
 * CareerCup 11.7
 * A circus is designing a tower routine consisting of people standing atop one another's 
 * shoulders. For practical and aesthetic reasons, each Person must be both shorter and lighter
 *  than the Person below him or her. Given the heights and weights of each Person in the circus,
 *  write a method to compute the largest possible number of people in such a tower.
 *   
 *  EXAMPLE:
 *  Input(ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 *  Output: The longest tower is length 6 and includes from top to bottom:
 *   (56, 90) (60, 95) (65, 100) (68, 110) (70, 150) (75, 190)
 *   
 *   
 *   
 */

package elevendot7;

import java.util.ArrayList;
import java.util.Collections;

public class CircusGame {
	 public static void main(String[] args){
         ArrayList<Person> items = new ArrayList<Person>();
         items.add(new Person(60,70));
         items.add(new Person(70,8));
         items.add(new Person(80,100));
         items.add(new Person(90,200));
         items.add(new Person(10,1));
         items.add(new Person(20,2));
         items.add(new Person(30,3));
         items.add(new Person(40,10));
         
         ArrayList<Person> solution = getIncreasingSequence(items);
         System.out.println(solution.size());
         for(Person p : solution){
        	 System.out.println("(" + p.height +","+ p.weight +")");
         }
	 }
	
	
	
	
	
	
	public static ArrayList<Person> getIncreasingSequence(ArrayList<Person> items){
        Collections.sort(items);
        return longestIncreasingSubsequence(items);
	}
	
	private static ArrayList<Person> longestIncreasingSubsequence(ArrayList<Person> items) {
        ArrayList<Person>[] solutions = (ArrayList<Person>[])new ArrayList[items.size()];
        longestIncreasingSubsequence(items,solutions,0);
        
        ArrayList<Person> best_sequence = null;
        for(int i = 0; i <items.size(); i++){
                best_sequence = seqWithMaxLength(best_sequence,solutions[i]);
        }
        return best_sequence;
	}

	
	 private static void longestIncreasingSubsequence(ArrayList<Person> items,
             ArrayList<Person>[] solutions, int currentIndex) {
     
		 if(currentIndex >= items.size() ||currentIndex <0)
			 return ;
		 Person current_element = items.get(currentIndex);
             
             /*find the longest sequence we can append current element to  */
             
		 ArrayList<Person> best_sequence = null;
		 for(int i = 0; i < currentIndex; i++){
			 	if(items.get(i).isBeneath(current_element)){
			 		best_sequence = seqWithMaxLength(best_sequence,solutions[i]);                
			 	}
		 }
             /*  append current element*/
		 ArrayList<Person> new_solution = new ArrayList<Person>();
		 if(best_sequence != null){
             new_solution.addAll(best_sequence);
		 }
		 new_solution.add(current_element);
     //add to list and recurse
     
		 solutions[currentIndex] = new_solution;
		 longestIncreasingSubsequence(items,solutions, currentIndex + 1);
	 }
	 
	 

	private static ArrayList<Person> seqWithMaxLength( ArrayList<Person> seq1, ArrayList<Person> seq2) {
     
		 if(seq1 == null){
             return seq2;
		 }
		 if(seq2 == null){
             return seq1;
		 }
		 return seq1.size() >= seq2.size() ? seq1 : seq2;
	 }

}



class Person implements Comparable<Person> {
	int height;
	int weight;
	
	
	Person(int height, int weight){
		this.height = height;
		this.weight = weight;
	}


	public boolean isBeneath(Person p){
		if(this.height < p.height && this.weight < p.weight){
			return true;
		}else
			return false;
	}


	@Override
	public int compareTo(Person p) {
		if(this.height != p.height )
			return this.height - p.height;
		else
			return this.weight - this.weight;
	}
	
	
}