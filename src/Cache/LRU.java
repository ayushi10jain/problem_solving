package Cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class LRU implements AssociativeCache {

    List<Node> nodeList = new LinkedList();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);

    LRU(){
        head.next = tail;
        tail.prev = head;
    }

    Map<Integer, Node> cacheMap = new HashMap();

    @Override public int get(final int data) {
        return 0;
    }

    @Override public void put(final int data, int data2) {

        if(cacheMap.containsKey(data)){
            Node n = new Node(data, data2);
            insert(n);
            cacheMap.put(data, n);
        }
        else {
            if(cacheMap.size() == Constant.size) {
           removeNode(tail.prev);
            }
            Node n = new Node(data, data2);
            insert(n);
            cacheMap.put(data, n);
        }

    }

    public void removeNode(Node node){
        cacheMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    public void insert(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;

    }

    // always add node in front

}
