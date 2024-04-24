package Cache2;

public class NAssociatoveCacheTest {

    public static void main(String[] args) {
        int setSize = 8;
        NAssoiativeCache nAssoiativeCache = new NAssoiativeCache(setSize, ALGO.LRU);
        nAssoiativeCache.put(1,2);
//        nAssoiativeCache.put(9,3);
//        nAssoiativeCache.put(17,3);
//        nAssoiativeCache.put(26,8);
      int value = (int) nAssoiativeCache.get(1);
      System.out.println("value"+value);
      if(null == ALGO.LRU){

      }
    }

}
