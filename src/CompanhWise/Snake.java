package CompanhWise;

import java.util.HashMap;
import java.util.Map;


public class Snake {
    int start;
    int end;

    private static Map<Integer, Snake> snakeMap = new HashMap<>();

    public Snake(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    public void fixSnake(int start, int end){
        snakeMap.put(start, new Snake(start, end));
    }

    public static Snake getSnake(int start){
       return snakeMap.get(start);
    }
}
