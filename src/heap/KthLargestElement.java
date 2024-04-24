package heap;

import java.util.PriorityQueue;


public class KthLargestElement {
    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 4, 5, 3};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);
        }
        int l =0;
        for(int i=0; i<k; i++){
            l = pq.remove();
        }
        System.out.println(l);
    }
}
