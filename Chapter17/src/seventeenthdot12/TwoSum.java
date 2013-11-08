package seventeenthdot12;

import java.util.ArrayList;

public class TwoSum {
	
	public static void main(String[]args){
		int[]a = {1,3,5,7,9,12};
		ArrayList<Result> al = new ArrayList<Result>();
		int sum = 10;
		al = findSum(a,sum);
		for(int i = 0; i < al.size();i++){
			Result r = al.get(i);
			System.out.println("(" + r.i +"," + r.j + ")");
		}
	
		return ;
	}

	
	 public static ArrayList <Result> findSum(int[]data,int sum){
		 Heapsort hs= new Heapsort();
		hs.sort(data);
		int[] b = new int[data.length];
		for(int i = 0 ; i < b.length; i++){
			b[i] = sum - data[i];
		}
		ArrayList <Result>al = new ArrayList<Result>(); 
		findPairs(data,b,al);
		return al;
		
	 }
	 
	 private static void findPairs(int[]a,int[]b,ArrayList <Result>al){
		 int i = 0;//set to point the start of a
			int j = b.length - 1; //set to point the end of b
			
			while(i != j){
				if(a[i] > b[j]){
					j--;
				}else if (a[i] < b[j]){
					i++;
				}else{
					al.add(new Result(i,j));
					i++;
					j--;
				}
			}
	 }
}
 class Result{
	 int i;
	 int j;
	 Result(int i , int j){
		 this.i = i;
		 this.j = j;
	 }
 }