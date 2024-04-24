package Cache;

import java.util.HashMap;


public class LFU implements AssociativeCache{

LFUNode head = new LFUNode(0,0);
LFUNode tail = new LFUNode(0,0);


    final static int cacheSize = 4;
    class DoubleLinkList{
        LFUNode head;
        int capacity;

        LFUNode tail;
        DoubleLinkList(LFUNode node, int capacity, LFUNode tail){
            this.capacity = capacity;
            head = node;
            this.tail = tail;
        }

    }

    public LFU(){
        head.next = tail;
        tail.prev = head;
    }
    HashMap<Integer,LFUNode>  cacheMap= new HashMap();
    HashMap<Integer, DoubleLinkList> frequencyMap = new HashMap();
    int min = 0;
    @Override public int get(final int data) {
        LFUNode lfuNode = cacheMap.get(data);
        updateFrequencyMap(lfuNode);
        return lfuNode.value;
    }

    @Override public void put(final int data, int data2) {
          if(cacheMap.containsKey(data)){
              LFUNode lfuNode = cacheMap.get(data);
              updateFrequencyMap(lfuNode);
          }
          if(cacheMap.size() == cacheSize){
            DoubleLinkList doubleLinkList = frequencyMap.get(min);
            LFUNode lfuNode = doubleLinkList.tail.prev;
            cacheMap.remove(lfuNode.key);
            if(doubleLinkList.capacity == 0 || doubleLinkList.capacity == 1){
                frequencyMap.remove(min);
            }else{
                lfuNode.prev.next = lfuNode.next;
                lfuNode.next.prev = lfuNode.prev;
            }
          }
          LFUNode lfuNode = new LFUNode(data, data2);
          lfuNode.frequency = 1;
          min = 1;
          cacheMap.put(data, lfuNode);
          updateFrequencyMapInsert(lfuNode.frequency, lfuNode);
    }

    private void updateFrequencyMapInsert(int frequency, LFUNode node) {
        int capacity = 0;
        if(!frequencyMap.containsKey(frequency)){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            capacity++;
            DoubleLinkList doubleLinkList = new DoubleLinkList(head, capacity, tail);
            frequencyMap.put(frequency,doubleLinkList);
        }else{
            DoubleLinkList doubleLinkList = frequencyMap.get(frequency);
            LFUNode head = doubleLinkList.head;
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            capacity++;
            doubleLinkList.capacity = capacity;
            frequencyMap.put(frequency,doubleLinkList);
        }
    }

    private void updateFrequencyMap(final LFUNode lfuNode) {
        DoubleLinkList doubleLinkList = frequencyMap.get(lfuNode.frequency);
        int capacity = doubleLinkList.capacity;
         // remove node from the dll
        LFUNode deleteNode = doubleLinkList.tail.prev;
        deleteNode.prev.next = deleteNode.next;
        deleteNode.next.prev = deleteNode.prev;
       capacity--;
        if(capacity == 0){
            frequencyMap.remove(lfuNode.frequency);
        }
        int freq = lfuNode.frequency;
        freq++;
        min = freq;
        updateFrequencyMapInsert(freq, lfuNode);
    }
}
