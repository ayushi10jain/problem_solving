package Cache2;

public class CacheElement<k,v,m> {
    public k key;
    public v value;
    CacheElement next;
    CacheElement prev;
    public m decision;

    public CacheElement(k key, v value){
        this.key = key;
        this.value = value;
    }

}
