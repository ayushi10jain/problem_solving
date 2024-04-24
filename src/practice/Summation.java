package practice;

public class Summation {

    public static void main(String[] args) {
        int []a = {4,2,2,1,1,1};
        int[] b = {3,3,3,6};

        b = {3,3, 6,3}
        getSwappedNumbers(getDesiredSum(a,b),a,b);
    }

    private static void getSwappedNumbers(final int desiredSum, int[]a, int[]b) {
        for(int i=0; i<a.length; i++){
            int currSum = 0;
            int first = a[i];
           int second = -1;
            for(int j=0; j<b.length; j++){
                second = b[j];
                int temp = a[i];
                 a[i] = b[j];
                 b[j] = temp;

                currSum = currSum+b[j];

                if(j == b.length-1){
                    if(currSum == desiredSum){
                        if( checkFirstArraySum(desiredSum,a)){
                            System.out.println("first ::" + first);
                            System.out.println("Second :::" + second);
                            break;
                        }
                    }
                }

                int temp1 = a[i];
                a[i] = b[j];
                b[j] = temp1;
            }

            System.out.println("curr ::::" +  currSum);

        }
    }

    private static boolean checkFirstArraySum(final int desiredSum, final int[] a) {
        int sum = 0;
        for(int num : a){
            sum = sum+num;
        }
        System.out.println("sum ::::" +  sum);
        if(sum == desiredSum){
            return true;
        }
        return false;
    }

    public static int getDesiredSum(int []a, int []b){
        int desiredSum =0;
        for(int num : a){
            desiredSum = desiredSum + num;
        }
       for(int num : b){
           desiredSum = desiredSum + num;
       }
       System.out.println("s ::::" +  desiredSum/2);
       return desiredSum/2;
    }

}
