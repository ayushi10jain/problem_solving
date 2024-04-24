package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class MergeKSortedList {

    static class Ele{
        int num;
        int index;
        int pos;

        public Ele(int num, int index, int pos){
            this.num = num;
            this.index = index;
            this.pos = pos;
        }

    }
    public static void main(String[] args) {
        int a[] = {1,5,9};
        int b[] = {7,8,10};
        int c[] = {2,3,5};
        int k = 3;
        PriorityQueue<Ele> pq = new PriorityQueue<Ele>((x,y)-> x.num - y.num);
              int  j=0;
              pq.add(new Ele(a[0], 0, 1));
        pq.add(new Ele(b[0], 0, 2));
        pq.add(new Ele(c[0], 0, 3));

        while(!pq.isEmpty())  {
            Ele ele1 = pq.poll();
            System.out.println(ele1.num);
            if(ele1.pos == 1){
                if(ele1.index+1 < a.length){
                    int newIndex = ele1.index+1;
                    pq.add(new Ele(a[newIndex], newIndex, 1));
                }
            }else if(ele1.pos == 2){
                if(ele1.index+1 < b.length){
                    int newIndex = ele1.index+1;
                    pq.add(new Ele(b[newIndex], newIndex, 2));
                }

            }else if(ele1.pos == 3){
                if(ele1.index+1 < c.length){
                    int newIndex = ele1.index+1;
                    pq.add(new Ele(c[newIndex], newIndex, 3));
                }
            }
        }
    }
}
