package elevendot1;
/**
 * CareerCup 11.1
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write 
 * a method to merge B into A in sorted order.....
 * 
*/
public class MergeArray {
	public static void main(String[] args){
		 int[] data1 = {1,3,5,7,9,0,0,0,0,0};
         int [] data2 = {2,4,6,8,10};
         mergearray(data1,data2,4);
         for(int i : data1)
        	 System.out.print(i + " ");
	}
	
	public static void mergearray(int[] data1, int[] data2, int lastIndexofLastData1Element){
		int index1 = lastIndexofLastData1Element;
		int index2 = data2.length - 1;
		int index = lastIndexofLastData1Element + 1 + index2 + 1  - 1;
		while(index1 >= 0 && index2 >=0){
			if(data1[index1] >= data2[index2]){
				data1[index--] = data1[index1--];
			}else{
				data1[index--] = data2[index2--];
			}
		}
		while(index2>=0){
			data1[index--] = data2[index2--];
		}
	}

}
