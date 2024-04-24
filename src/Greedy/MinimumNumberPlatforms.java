package Greedy;

import java.util.Arrays;


public class MinimumNumberPlatforms {



    public static void main(String[] args) {
        int arr[]={900,945,955,1100,1500,1800};
        int dep[]={920,1200,1130,1150,1900,2000};
        Arrays.sort(dep);
        int platforms = numberOfPlatforms(arr, dep, dep.length);
        System.out.println(platforms);
    }


    public static int numberOfPlatforms(int a[] , int d[], int n){
        int platform = 1;
        int limit = d[0];
        int ans = 1;
        for(int i=1; i<d.length; i++) {
            if(limit > a[i]){
                platform++;
                limit = Math.min(limit,d[i]);

            }else {
                platform = 1;
                limit = d[i];
            }
            ans = Math.max(ans,platform)  ;
        }
        return ans;
    }
}
