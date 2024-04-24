package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;


public class VotingApplication {

    static int max_config = 3;
    static Map<String, Integer> canditateToPointMap = new HashMap();
    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();
        voters.add("Ram");
        voters.add("Shyam");
        voters.add("zzz");

        List<String> voters1 = new ArrayList<>();
        voters1.add("Shyam");
        voters1.add("zzz");
        voters1.add("Ram");


     Ballot ballot = new Ballot(voters);
     Ballot ballot2 = new Ballot(voters1);
     List<Ballot> ballotList = new ArrayList<>();
     ballotList.add(ballot);
     ballotList.add(ballot2);
     List<String> votersList = getResults(ballotList);
     for(String voter : votersList){
         System.out.println(voter);
     }
    }

    private static List<String> getResults(final List<Ballot> ballot) {
        if( (ballot==null || ballot.isEmpty() )){
            return Arrays.asList("");
        }
       // createMap()
        for( int i=0; i<ballot.size(); i++){
            Ballot ballot1 = ballot.get(i);
            if(ballot1 == null || ballot1.getVoters().isEmpty()){
                continue;
            }
            for (int j = 0; j < ballot1.getVoters().size(); j++) {
                int points = 0;
                if (!canditateToPointMap.containsKey(ballot1.getVoters().get(j))) {
                    points = getPoints(j);
                    canditateToPointMap.put(ballot1.getVoters().get(j), points);
                } else {
                    points = canditateToPointMap.get(ballot1.getVoters().get(j)) + getPoints(j);
                    canditateToPointMap.put(ballot1.getVoters().get(j), points);
                }

            }
        }

        List<Map.Entry<String, Integer> > list
                = new ArrayList<>(
                canditateToPointMap.entrySet());

       // List<String> voterkey = Arrays.asList(Arrays.toString(canditateToPointMap.keySet().toArray()));

        Collections.sort(
                list,
                (i1, i2) -> i2.getValue().compareTo(i1.getValue()));


        List<String> resultList = new ArrayList();
         return list.stream().map(l -> l.getKey()).collect(Collectors.toList());
//        for(int i=0; i<list.size(); i++){
//            resultList.add(list.get(i).getKey());
//        }
 //       return resultList;
    }

    // this can be optimised to map.
    private static int getPoints(final int i) {
        // switch cpuld be used
        if (i == 0) {
            return max_config;
        } else if (i == 1) {
            return max_config-1;
        } else if (i == 2) {
            return max_config-2;
        }
        return 0;
    }


}
