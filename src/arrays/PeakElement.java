package arrays;

public class PeakElement {
    public static void main(String[] args) {
       int[] a = {1,2, 1,1,1,1};
       System.out.println(findPeakElement(a,0,a.length-1));

    }

    public static int findPeakElement(int [] a, int l, int r){

     while(l<r){
         int mid = l+(r-l)/2;
         if(a[mid]>a[mid+1]){
           r=mid;
         }else{
             l = mid+1;
         }
     }
return l;
    }
}
