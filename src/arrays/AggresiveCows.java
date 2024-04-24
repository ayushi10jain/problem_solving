package arrays;

import java.util.Arrays;


public class AggresiveCows {

    public static void main(String[] args) {
        int [] stalls = {1, 2,3,5,8, 9};
        Arrays.sort(stalls);
        int cows = 4;
        int h = stalls.length -1;
        int l = stalls[0];
        int r = stalls[h];
        while(l<=r){
            int mid = (l+r)/2;
            if(possible(mid, stalls, cows)){
               l = mid+1 ;
            }else {
                r = mid - 1;
            }
        }
        System.out.println(r);
    }

    private static boolean possible(final int mid, final int[] stalls, final int cows) {
        int lastCowPlaced = stalls[0];
        int cow = 1;
        for (int i=1; i<stalls.length; i++){
            if(Math.abs(lastCowPlaced - stalls[i]) >= mid){
                cow++;
                lastCowPlaced = stalls[i];
            }
        }
        if(cow<cows){
            return false;
        }

        return true;
    }
}
