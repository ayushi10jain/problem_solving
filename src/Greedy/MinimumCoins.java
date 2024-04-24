package Greedy;

import java.util.ArrayList;
import java.util.List;


public class MinimumCoins {
    public static void main(String[] args) {

        int V = 49;
        ArrayList< Integer > ans = new ArrayList < > ();
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int n = coins.length;
        int noOfCoins = 0;
        List<Integer> result = new ArrayList();
        for (int i = n-1; i >=0; i--) {
            while(coins[i] < V){
                noOfCoins = noOfCoins + 1;
                result.add(coins[i]);
                V = V-coins[i];
            }
        }
        System.out.println(noOfCoins);
        System.out.println(result);
    }

}
