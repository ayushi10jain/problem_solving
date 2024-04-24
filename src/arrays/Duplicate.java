package arrays;

import java.util.ArrayList;
import java.util.List;


public class Duplicate {

    public static void main(String[] args) {
        int[] a = {0,1,1,8,2,2,2,3,4,4};
        List<String> s = packNumbers(a);
        for(String g : s){
            System.out.println(s);
        }
    }


    private static List<String> packNumbers(final int[] a) {
        System.out.println(a);
        List<String> s = new ArrayList();
        int j=0;
        int i =0;
        for( i=0; i<a.length; i++){
            if(a[i] != a[j]){

                if(i-j > 1) {
                    int count = i - j;
                    s.add(a[j] + ":" + count);
                }else if(i-j == 1){
                    s.add(String.valueOf(a[j]));
                }
                j=i;
            }
        }
        if(i-j > 1) {
            int count = a.length - j;
            s.add(a[j] + ":" + count);
        }else if(i-j == 1){
            s.add(String.valueOf(a[j]));
        }
        return s;
    }

}
