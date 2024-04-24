package Cache2;

import java.util.HashMap;
import java.util.Map;


public class CacheSet<k,v,m> {
    CacheElement head;
    CacheElement tail;

    Map<k, CacheElement> cacheMap = new HashMap<>();

    public int cacheLineSize = 3;

    public CacheSet() {
        this.head = new CacheElement(0, 0);
        this.tail = new CacheElement(0, 0);
        head.next = tail;
        tail.prev = head;
    }
}


