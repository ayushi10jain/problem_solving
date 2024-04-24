package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class JobSequencing {
    static class Job{
        int id;
        int deadline;
        int profit;
        public Job(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int[] JobScheduling(Job[] jobs, int n){
        int [] result = new int[2];
        // sort job based on profit;
        int [] days = new int [n+1];
        Arrays.fill(days, -1);
        int maxprofit = 0;
        int noOfJobs =0;
        Arrays.sort(jobs, (a,b) -> b.profit - a.profit);
        for(int i=0; i<jobs.length; i++){
            int id = jobs[i].deadline;
            while(id>0 && days[id]!=-1) {
                id--;
            }
            if(days[id] == -1 && id!=0) {
                days[id] = jobs[i].id;
                maxprofit = maxprofit + jobs[i].profit;
                noOfJobs = noOfJobs + 1;
            }
        }
        result[0]=noOfJobs;
        result[1]=maxprofit;
        return result;
    }

    public static int[] JobSchedulingQueue(Job[] jobs, int n){
        int [] result = new int[2];
        Arrays.sort(jobs,(a,b) -> a.deadline - b.deadline);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>();
        return result;
    }

    public static void main(String[] args) {


            //size of array
            Job[] arr = new Job[4];
            arr[0] = new Job(1, 4, 20);
            arr[1] = new Job(2, 1, 10);
            arr[2] = new Job(3, 2, 40);
            arr[3] = new Job(4, 2, 30);


            //function call
            int[] res = JobScheduling(arr, 4);
            System.out.println(res[0] + " " + res[1]);

        }
}
