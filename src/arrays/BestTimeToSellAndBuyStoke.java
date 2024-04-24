package arrays;

public class BestTimeToSellAndBuyStoke {
    public static void main(String args[]){
        int[] a = {7,1,5,3,6,4};
//        int s = getMaxProfitSingleScan(a);
//        System.out.println(s);
        int s = getMaxProfitSingleScanPeakAndValley(a);
        System.out.println(s);
    }
    static int i = 0;
    private static int getMaxProfitSingleScanPeakAndValley(final int[] a) {
        if(a.length == 1){
            return 0;
        }
        int maxProfit = 0;
        while(i<a.length-1) {
            int valley = findValley(a);
            int peak = findPeak(a);
            maxProfit = maxProfit + (peak - valley);

        }

        return maxProfit;
    }

    private static int findValley(final int[] a) {
        while(i<a.length-1 && a[i]>=a[i+1]){
            i++;
        }
        return a[i];
    }

    private static int findPeak(final int[] a) {
        while(i<a.length-1 && a[i]<=a[i+1]){
            i++;
        }
        return a[i];
    }

    private static int getMaxProfitSingleScan(final int[] a) {
        int profit = 0;
       for(int i=1; i<a.length; i++){
           if(a[i] > a[i-1]){
               profit = profit + a[i]-a[i-1];
           }
       }
        return profit;
    }
}
