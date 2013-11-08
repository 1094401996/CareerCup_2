package seventeenthdot12;

public class Heapsort {
	private int[] data;
	
	
	public Heapsort(){
		
	}
	
	public void sort(int[] data){
		this.data = data;
		heapsort();
	}
	private void heapsort(){
		buildHeap();
		for(int i = data.length - 1; i > 0; i--){
			swap(0,i);
			heapify(0,i);
		}
	}
	
	private void buildHeap(){
		for(int i = data.length / 2 - 1; i>= 0 ; i--){
			heapify(i);
		}
	}
	
	// i 堆化的起点
	private void heapify(int i){
		heapify(i, data.length );
	}
	// size 表示堆化的范围
	private void heapify(int i , int heapsize){
		int left = left(i);
		int right = right(i);
		int largest = i;
		if(left < heapsize && data[left] > data[largest]){
			largest = left;
		}
		if(right < heapsize&& data[right] > data[largest]){
			largest = right;
		}
		
		if(largest != i){
			swap(i,largest);
			heapify(largest,heapsize);
		}
	}
	
	private void swap(int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		return ;
	}
	private int parent(int i){
		return i/2;
	}
	
	private int left(int i){
		return 2*i;
	}
	private int right(int i){
		return 2 * i + 1;
	}
	
	
	public static void main(String[] args){
		int[] data = { 2,3,4,5,-2,-7,9};
		Heapsort hs = new Heapsort();
		hs.sort(data);
		for( int i = 0 ; i < data.length; i ++){
			System.out.print(data[i] + " ");
		}
	}

}
