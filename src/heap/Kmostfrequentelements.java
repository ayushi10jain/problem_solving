package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import jdk.internal.util.xml.impl.Pair;


public class Kmostfrequentelements {
    public static void main(String[] args) {
        int [] a = {2,2,1,1,1,3};
        int k =3;
     Map<Integer,Integer> hm = new HashMap<>();
     for(int i=0; i <a.length; i++){
         if(hm.containsKey(a[i])) {
             hm.put(a[i], hm.get(a[i])+1);
         }else{
             hm.put(a[i], 1);
         }
    }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((o1,o2)-> o2.getValue()-o1.getValue());
     Pair pair;
     for(Map.Entry<Integer,Integer> m :hm.entrySet()) {
        pq.add(m);
     }
     for(int i=0; i<k;i++){
         System.out.println(pq.poll().getKey());
     }
    }
}
