package eighteenthdot09;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindMedian {
	
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10,new MaxHapComparator());
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	
	public static void main(String[]args){
		FindMedian fm = new FindMedian();
		fm.addNewNumber(1);
		fm.findMedian();
		fm.addNewNumber(2);
		fm.findMedian();
		fm.addNewNumber(3);
		fm.findMedian();
		fm.addNewNumber(4);
		fm.findMedian();
		fm.addNewNumber(5);
		fm.findMedian();
		fm.addNewNumber(6);
		fm.findMedian();
		fm.addNewNumber(7);
		fm.findMedian();

		
	}
	
	public  void findMedian(){
				if(maxHeap.size() == minHeap.size()){
					System.out.println(((double)maxHeap.peek() + (double)minHeap.peek()) /2);
				}else if (maxHeap.size() > minHeap.size()){
					System.out.println(maxHeap.peek());
				}else{
					System.exit(-1);
				}
	}
		public void addNewNumber(int randomNumber){
			if(maxHeap.size() == minHeap.size()){
				if(minHeap.peek() != null){
					if(minHeap.peek() >= randomNumber){
						maxHeap.offer(randomNumber);
					}else{
						maxHeap.offer(minHeap.poll());
						minHeap.offer(randomNumber);
					}
				}else{
					maxHeap.offer(randomNumber);
				}
			}else{
				if(maxHeap.peek() > randomNumber){
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(randomNumber);
				}else{
					minHeap.offer(randomNumber);
				}
			}
		}
	

}
