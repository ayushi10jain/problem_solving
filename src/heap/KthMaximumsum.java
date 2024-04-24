package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import com.sun.tools.javac.util.Pair;

import static heap.KthMaximumsum.Triplet;


public class KthMaximumsum {

    static class  Triplet{
        int sum;
        int start;
        int end;
        public Triplet(int sum, int start, int end){
           this.sum = sum;
           this.start = start;
           this.end = end;
        }
    }

    public static void main(String[] args) {
        int A[] = { 4, 2, 5, 1 };
        int B[] = { 8, 0, 5, 3 };
        int N = A.length;
        int K = 3;

        // Function Call
        List<Integer> list = KMaxCombinations(A, B, N, K);
        for(int i =0; i<list.size(); i++){
            System.out.println("i is :" + list.get(i));
        }
    }

    private static List<Integer> KMaxCombinations(final int[] a, final int[] b, final int n,  int k) {
        Arrays.sort(a);
        Arrays.sort(b);
        HashSet<Pair> hs = new HashSet<>();
        List<Integer> list = new ArrayList<>();

            int sum = a[n-1] + b[n-1];
            int start = n-1;
            int end =   n-1;
            hs.add(new Pair(start, end));
            Triplet triplet = new Triplet(sum, start, end);

            PriorityQueue<Triplet> pq = new PriorityQueue<>((o1,o2) -> o1.sum - o2.sum);
            pq.add(triplet);
            while(!pq.isEmpty() && k >0){
                k = k-1;
                Triplet triplet1 = pq.poll();
                int nstart = triplet1.start;
                int nend = triplet1.end -1 ;
                list.add(triplet1.sum);
                Pair pair1 = Pair.of(nstart, nend);

                if( nstart>=0 && nend>=0 && !hs.contains(pair1)){
                    hs.add(pair1);
                    pq.add(new Triplet(a[nstart] + b[nend], nstart, nend));
                }
                nstart = triplet1.start-1;
                nend = triplet1.end;
                Pair pair2 = Pair.of(nstart, nend);

                if(nstart>=0 && nend>=0 && !hs.contains(pair2)){
                    hs.add(pair2);
                    pq.add(new Triplet(a[nstart] + b[nend], nstart, nend));
                }
            }
        return list;
    }
}
