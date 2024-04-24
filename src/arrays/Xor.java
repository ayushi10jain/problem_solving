package arrays;

import java.util.HashMap;


public class Xor {

    public static void main(String[] args) {
        Xor obj = new Xor();
        int[] A = new int[]{4,2,2,6,4};
        int countTotal=obj.solve(A,6);
        System.out.println("The total number of subarrays having a given XOR k is "+countTotal);
    }
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> hm = new HashMap();
        int curXor = 0;
        int count =0;
        for(int i=0; i<A.length; i++){
            curXor = curXor^A[i];
            int x = curXor^B;
            if(hm.get(x) != null)
                count+= hm.get(x);
            if(curXor==B){
                count++;
            }
            if(hm.get(curXor)!=null){
                hm.put(curXor,hm.get(curXor)+1);
            }else{
                hm.put(curXor,1);
            }
        }
        return count;
    }
}
