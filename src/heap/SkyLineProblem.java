package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import Cache2.ALGO;
import jdk.internal.util.xml.impl.Pair;


public class SkyLineProblem {

    static class  Points implements Comparable<Points> {
        int x;
        int h;
        boolean start;

        public Points(int x, int h, boolean start){
            this.x = x;
            this.h = h;
            this.start = start;
        }


        @Override public int compareTo(final Points o) {
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.start ? -this.h : this.h) - (o.start ? -o.h : o.h);
            }
            }

    }

    public static void main(String[] args) {
        if(null == ALGO.LRU){

        }
        int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
        SkyLineProblem sd = new SkyLineProblem();
      List<int []> points =  getSkyLinePoints(buildings);
      for(int i=0; i<points.size(); i++){
         int x = points.get(i)[0];
         int y = points.get(i)[1];
         System.out.println("[" + x + "-" + y + "]");
      }

    }

    private static List<int[]> getSkyLinePoints(final int[][] buildings) {
        List<int []> result = new ArrayList<>();
        Points [] points = new Points[buildings.length * 2];
        int index = 0;
        for(int i=0; i<buildings.length; i++){
            Points points1 = new Points(buildings[i][0],buildings[i][2], true);
            Points points2 = new Points(buildings[i][1],buildings[i][2], false);
            points[index]=points1;
            index++;
            points[index]=points2;
            index++;
        }
        Arrays.sort(points);
        TreeMap<Integer, Integer> heightCount = new TreeMap();
        heightCount.put(0, 1);
        int prevHeight = 0;
        for (Points pointsi : points) {
            if (pointsi.start == true) {
                if (heightCount.containsKey(pointsi.h)) {
                    int heightc = heightCount.get(pointsi.h);
                    heightc++;
                    heightCount.put(pointsi.h, heightc);
                } else {
                    heightCount.put(pointsi.h, 1);
                }
            } else {
                int heightc = heightCount.get(pointsi.h);
                heightc--;
                if(heightc==0){
                    heightCount.remove(pointsi.h);
                }else{
                    heightCount.put(pointsi.h, heightc);
                }
            }
            int currHeight = heightCount.lastKey();
            if(currHeight!=prevHeight){
                int[] skyPoints = new int[2];
                skyPoints[0] = pointsi.x;
                skyPoints[1] = currHeight;
                result.add(skyPoints);
                prevHeight = currHeight;
            }
        }
      return result;
    }

}



