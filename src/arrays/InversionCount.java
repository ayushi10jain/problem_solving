package arrays;

public class InversionCount {
    public static void main(String[] args) {

            int arr[]={5,3,2,1,4};
            int n=5;
            int [] temp = new int[5];
            int ans = merge_Sort(arr,temp,0,n-1);
System.out.println(ans);

    }

    private static int merge_Sort( int[] arr,  int[] temp,  int l,  int h) {
        int count =0;
        int mid = 0;
        if(l<h){
             mid = l+(h-l)/2;

            count = count + merge_Sort(arr, temp, l, mid);
            count = count + merge_Sort(arr, temp, mid+1, h);
            count = count + merge_final(arr, temp, mid, l, h);
        }
        return count;
    }

    private static int merge_final(final int[] arr,  int[] temp, final int mid,  int l, final int h) {
        int i = l;
        int right = mid+1;
        int right_c = mid+1;
        int k = l;
        int count = 0;
        while(l<=mid  && right<=h){
            if(arr[l]<= arr[right]){
                temp[k] = arr[l];
                l++;
                k++;
            }else{
                temp[k] = arr[right];

                count = count + (right_c - l);
                right++;
                k++;
            }
        }
        while(l<=mid){
            temp[k] = arr[l];
            l++;
            k++;
        }
        while(right<=h){
            temp[k] = arr[right];
            right++;
            k++;

        }
        for(int x =i; x<=h; x++){
            arr[x] = temp[x];
        }
        return count;
    }

}
