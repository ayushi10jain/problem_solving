package arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] a = {1,1,2,2,2,3,4,4};
        int s = removeDupliactes(a);
        System.out.println(s);
    }

    private static int removeDupliactes(final int[] a) {
        int j=0;
        for(int i=0; i<a.length-1; i++){
            if(a[i] != a[i+1]){
                a[j] = a[i];
                j++;
            }
        }
        return j;
    }

}
