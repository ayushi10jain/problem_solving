package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class NMeetingInARoom {

    static class Meeting {
        int start;
        int end;
        int pos;
        Meeting(int start,int end,int pos){
          this.start = start;
          this.end = end;
          this.pos = pos;
        }
    }

    static class meetingCompataor implements Comparator<Meeting>{

        @Override public int compare(final Meeting o1, final Meeting o2) {
            {
                if (o1.end < o2.end)
                    return -1;
                else if (o1.end > o2.end)
                    return 1;
                else if(o1.pos < o2.pos)
                    return -1;
                return 1;
            }

        }
    }

    public static List<Integer> maxMeetings(int[] start, int[] end, int n){
        List<Integer> noOfMeeting = new ArrayList();
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<n; i++){
            meetings.add(new Meeting(start[i], end[i], i+1));
        }

        meetingCompataor mc = new meetingCompataor();
        Collections.sort(meetings, mc);
        int lastEndTime;
        noOfMeeting.add(meetings.get(0).pos);
         lastEndTime = meetings.get(0).end;
        for(int i=1; i<meetings.size(); i++){
            if(meetings.get(i).start > lastEndTime){
                noOfMeeting.add(meetings.get(i).pos);
                lastEndTime = meetings.get(i).end;
            }
        }
      return noOfMeeting;
    }

    public static void main(String args[])
    {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,8,10,9,9};
        maxMeetings(start,end,n);

    }
}


