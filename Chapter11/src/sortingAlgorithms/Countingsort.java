package sortingAlgorithms;

public class Countingsort {
        private int[]data;
        public Countingsort(){
        }
        
        public void sort(int[]data){
        		this.data = data;
                int range = findMax() + 1;
                int[] helper = new int[range + 1];
                
                for(int i = 0 ; i < data.length; i++){
                	helper[data[i]]++;
                }
                int j = 0;
                int ptr = 0; 
                while(j < helper.length){
                	if(helper[j] != 0){
                		data[ptr++] = j;
                		helper[j] --;
                	}
                	j++;
                }
               
                
        }
        
        private int findMax(){
                int max = data[0];
                for(int i = 0 ; i < data.length; i++){
                        if(data[i] > max){
                                max = data[i];
                        }
                }
                return max;
        }
        private int findMin(){
                int min = data[0];
                for(int i = 0 ; i < data.length; i++){
                        if(data[i] < min){
                                min = data[i];
                        }
                }
                return min;
        }
        
        public static void main(String[] args){
                int [] a = {5,4,3,2,1};
                Countingsort cs = new Countingsort();
                cs.sort(a);
                for(int i : a){
                        System.out.print(i + " ");
                }
        }
}