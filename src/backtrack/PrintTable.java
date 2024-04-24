package backtrack;

import java.util.Arrays;


public class PrintTable {

    public static void main(String[] args) {
        int n = 5;
        table( n, 10);
    }

    private static void table(final int n, final int i) {
        if(i == 1){
            System.out.println(n*i);
            return;
        }
        table(n,i-1);
        System.out.println(n*i);

        // you can also use imports, for example:
        // import java.util.*;

        // you can write to stdout for debugging purposes, e.g.
        // System.out.println("this is a debug message");

        class Solution {
            public int solution(int[] A) {
                Arrays.sort(A);
                int l = A.length;
                if(A[l-1] < 0 || A[l-1] == 0){
                    return 1;
                }

                for(int i=0; i<l; i++){
                    if(A[i] != i+1){
                        return i+1;
                    }
                }
                return A[l-1] + 1;
            }
        }

    }
}
