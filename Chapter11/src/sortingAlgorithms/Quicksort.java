package sortingAlgorithms;

public class Quicksort<E extends Comparable<E>> {
        private E[] data;
        
        public void sort(E[] e){
                this.data = e;
                quicksort(data, 0 , data.length - 1);
        }
        
        private void quicksort(E[] data, int left, int right){
                if(right > left){
                        
                        int pivotindex = partition(data,left, right);
                        quicksort(data, left, pivotindex - 1);
                        quicksort(data, pivotindex + 1, right);
                }
        }

        private int partition(E[] data, int left, int right){
                int i = left - 1;
                E pivot = data[right];
                E temp ;
                for(int j = left; j < right ;j++){
                        if(data[j].compareTo(pivot) <= 0){
                                i++;
                                temp = data[j];
                                data[j] = data[i];
                                data[i] = temp;
                        }
                }
                temp = data[right];
                data[right] = data[i + 1];
                data[i + 1] = temp ;
                return i + 1;
        }
        

}