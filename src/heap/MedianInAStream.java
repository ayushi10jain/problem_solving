package heap;

import java.util.PriorityQueue;


public class MedianInAStream {
    public static void main(String[] args) {
        int [] c = {5, 15, 6, 10, 8, 3, 20, 0, };
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        int median = c[0];

        maxHeap.add(c[0]);
        for(int i=1; i<c.length; i++){
           int x = c[i];
           System.out.println(median);
           if(x > median ){
               // put in max heap
               if(minHeap.size() < maxHeap.size()){
                   minHeap.add(x);
                   median = (minHeap.peek()+maxHeap.peek())/2;
               }else if(minHeap.size() == maxHeap.size()){
                   minHeap.add(x);
                   median = maxHeap.peek();
               }else{
                   maxHeap.add(minHeap.poll());
                   minHeap.add(x);
                   median = (minHeap.peek() + maxHeap.peek() )/ 2;
               }

           }else {
               if (maxHeap.size() < minHeap.size()) {
                   maxHeap.add(x);
                   median = (minHeap.peek() + maxHeap.peek() )/ 2;
               } else if (minHeap.size() == maxHeap.size()) {
                   maxHeap.add(x);
                   median = maxHeap.peek();
               } else {
                   minHeap.add(maxHeap.poll());
                   maxHeap.add(x);
                   median = (minHeap.peek() + maxHeap.peek() )/ 2;
               }

           }
        }


    }
}
