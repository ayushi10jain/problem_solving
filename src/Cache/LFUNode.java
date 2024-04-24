package Cache;

public class LFUNode {
    int key;
    int value;
    int frequency;
    LFUNode prev;
    LFUNode next;

    LFUNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
