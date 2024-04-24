package Cache;

public class Node {
    int key;
    Node prev;
    Node next;

    int value;

    public Node(int key, int value){
        this.key = key;
       this.value = value;
    }
}
