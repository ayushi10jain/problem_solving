package Cache2;

public interface  ReplacementAlgo {
     void updateNode(CacheElement node, CacheElement head);



     void removeNode(CacheElement node);


     void insertNode(CacheElement node, CacheElement head);
}
