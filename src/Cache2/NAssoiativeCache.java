package Cache2;

public class NAssoiativeCache<k,v,m> implements Cache<k,v,m>{

    int setSize;
    ALGO algo;
    CacheSet[] cacheSets ;

    public NAssoiativeCache(int setSize, ALGO algo){
        this.algo = algo;
        this.setSize = setSize;
        cacheSets = new CacheSet[setSize];
        for(int i =0; i<setSize; i++){
            cacheSets[i] = new CacheSet();
        }
    }


    @Override public void put(final k key, final v value) {
        int index = getCacheset(key);
        CacheSet cacheSet = cacheSets[index];
        if(cacheSet.cacheMap.get(key)!=null){
            CacheElement cacheElement = (CacheElement) cacheSet.cacheMap.get(key);
            cacheSet.cacheMap.put(key,cacheElement);
            getAlgo(algo).updateNode(cacheElement, cacheSet.head);
        }
        else if(cacheSet.cacheMap.size() == cacheSet.cacheLineSize){
                getAlgo(algo).removeNode(cacheSet.tail.prev);
        }
        CacheElement cacheElement = new CacheElement(key, value);
        cacheSet.cacheMap.put(key,cacheElement);
        getAlgo(algo).insertNode(cacheElement, cacheSet.head);
    }

    int getCacheset(k key){
      return  key.hashCode() % setSize;
    }

    @Override public v get(final k key) {
        int index = getCacheset(key);
        CacheSet cacheSet = cacheSets[index];
        CacheElement ce = (CacheElement) cacheSet.cacheMap.get(key);
        getAlgo(algo).updateNode(ce, cacheSet.head);
        return (v) ce.value;
    }

    ReplacementAlgo getAlgo(ALGO algo){

        if(algo.equals(ALGO.LRU)){
            return new LRUC();
        }else if(algo.equals(ALGO.LFU)){
            return new LFUC();
        }
        return null;
    }
}
