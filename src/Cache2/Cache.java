package Cache2;

public interface Cache <k,v,m>{
     void put(k key, v value);
     v get (k key);
}
