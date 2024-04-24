package Cache2;

public class LRUC implements ReplacementAlgo{
    @Override public void updateNode(final CacheElement node, CacheElement head) {
        removeNode(node);
        insertNode(node, head);
    }

    @Override public void removeNode(final CacheElement node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    @Override public void insertNode(final CacheElement node, CacheElement head) {
         node.next = head.next;
         node.prev = head;
         head.next.prev = node;
         head.next = node;
    }
}
