package Greedy;

import java.util.Arrays;


public class KnapsackFrictional {
    static class Item{
        int value;
        int weight;

        int fraction;

        public void setFraction(int fraction){
            this.fraction = fraction;
        }

        public int setFraction(){
           return this.fraction;
        }

        public  Item(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }

    public static double fractionalKnapsack(int weight, Item [] itemArray , int n){
        for(int i=0; i<n; i++){
           Item item = itemArray[i];
           item.setFraction(item.value/item.weight);
        }
        double value = 0;
        Arrays.sort(itemArray, (a,b) -> b.fraction - a.fraction);
        for(int i=0; i<n; i++){
             if(itemArray[i].weight < weight){
                weight = weight - itemArray[i].weight;
                value = value + itemArray[i].value;
            }else if(itemArray[i].weight >= weight){
                value = value + ((itemArray[i].value/itemArray[i].weight)*weight);
                return value;
            }
        }
        return 0.0;
    }

    public static void main(String args[])
    {
        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);
    }
}
