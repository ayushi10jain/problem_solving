package MeetingScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.sun.tools.javac.util.Pair;
import Greedy.NMeetingInARoom;


public class PersonMettingScheduler {
    static Map<String, Set<Slot>> personsCalenderMapBooked = new HashMap();
    static Map<String, Set<Slot>> personsCalenderMapFree = new HashMap();
    static Map<String, Meeting> meetingMap = new HashMap();

    static int start = 10;
    static int end = 19;

    public static void main(String[] args) {

        bookMeeting(10, 11, Arrays.asList("a", "b"));
        getAllFreeSlots(60, Arrays.asList("a", "b", "c"));
    }

    private static void getAllFreeSlots(final int duration, final List<String> asList) {
    }

    public Set getSlotsAM() {
        Set<Slot> slotsAM = new HashSet();
        slotsAM.add(new Slot(10, 11));
        slotsAM.add(new Slot(11, 12));
        slotsAM.add(new Slot(12, 13));
        slotsAM.add(new Slot(13, 14));
        slotsAM.add(new Slot(14, 15));
        slotsAM.add(new Slot(15, 16));
        slotsAM.add(new Slot(16, 17));
        slotsAM.add(new Slot(17, 18));
        slotsAM.add(new Slot(18, 19));
        return slotsAM;
    }

    public Set getSlotsPM() {
        Set<Pair> slotsPM = new HashSet();
        return slotsPM;
    }

    public static Meeting bookMeeting(int stratTime, int endTime, List<String> attendeeList) {
        int duration = Integer.valueOf(endTime) - Integer.valueOf(stratTime);
        Meeting meeting = null;
        if (personsCalenderMapBooked.size() == 0) {
            meeting = createMeeting(stratTime, endTime, attendeeList);
        } else {
            for (String name : attendeeList) {
                Set<Slot> bookedSlots = personsCalenderMapBooked.get(name);
                while (Integer.valueOf(stratTime) < Integer.valueOf(endTime)) {
                    if (bookedSlots.contains(stratTime)) {
                        break;
                    } else {
                        stratTime = stratTime + 1;
                    }
                }
                if (Integer.valueOf(stratTime) < Integer.valueOf(endTime)) {
                    System.out.println("meeting cannot be booked as the slot is not free");
                    throw new NoCommonSlotsAvailable();
                }
            }
            meeting = createMeeting(stratTime, endTime, attendeeList);

        }
        return meeting;
    }

    private static Meeting createMeeting(final int stratTime, final int endTime, final List<String> attendeeList) {
        Meeting meeting = new Meeting();
        meeting.attendees = attendeeList;
        meeting.startTime = stratTime;
        meeting.endTime = endTime;
        meetingMap.put("m1_1", meeting);
        updatePersonCalendar(attendeeList, stratTime, endTime);
        return meeting;
    }

    private static void updatePersonCalendar(final List<String> attendeeList, final int stratTime,
            final int endTime) {
        for (String name : attendeeList) {
            if (!personsCalenderMapBooked.containsKey(name)) {
                Set<Slot> p = new HashSet();
                Slot bookedPair = new Slot(stratTime, endTime);
                p.add(bookedPair);
                personsCalenderMapBooked.put(name, p);
                Set<Slot> d = new HashSet<>();
                Slot freePair1 = new Slot(start, stratTime);
                Slot freePair2 = new Slot(endTime, end);
                d.add(freePair1);
                d.add(freePair2);
                personsCalenderMapFree.put(name, d);
            } else {
                Set<Slot> bookedSlots = personsCalenderMapBooked.get(name);
                bookedSlots.add(new Slot(stratTime, endTime));
                personsCalenderMapBooked.put(name, bookedSlots);

                Set<Slot> freeSlots = personsCalenderMapFree.get(name);
                if (freeSlots.isEmpty()) {
                    freeSlots.add(new Slot(start, stratTime));
                    freeSlots.add(new Slot(endTime, end));
                } else {
                    if (freeSlots.contains(new Slot(stratTime, endTime))) {
                        for (Slot fslot : freeSlots) {
                            if (fslot.endTime == endTime && fslot.sTime == stratTime) {
                                freeSlots.remove(stratTime);
                            } else if (fslot.sTime == stratTime) {
                                freeSlots.add(new Slot(endTime, fslot.endTime));
                            } else if (fslot.endTime == endTime) {
                                freeSlots.add(new Slot(stratTime, fslot.sTime));
                            } else if (fslot.sTime < stratTime && fslot.endTime > endTime) {
                                freeSlots.add(new Slot(fslot.sTime, stratTime));
                                freeSlots.add(new Slot(endTime, fslot.endTime));
                            }

                        }

                    }
                }
                personsCalenderMapFree.put(name, freeSlots);

            }
        }
    }

}
