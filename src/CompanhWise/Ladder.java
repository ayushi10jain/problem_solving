package CompanhWise;

import java.util.HashMap;
import java.util.Map;
import Cache.AssociativeCache;


public class Ladder {
    int start;
    int end;

    public static Map<Integer, Ladder> ladderMap = new HashMap<>();

    public Ladder(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    public void fixLadder(final int start, final int end) {
        ladderMap.put(start, new Ladder(start, end));
    }

    public static Ladder getSnake(int start){
        return ladderMap.get(start);
    }

}
