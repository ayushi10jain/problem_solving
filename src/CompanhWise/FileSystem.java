package CompanhWise;

import java.util.HashMap;
import java.util.Map;


public class FileSystem {
    public static Map<String,Integer> pathMap = new HashMap();
    public static void main(String[] args) {
        String input ="/leet/leetCode";
        String input1 ="/leet";
        String input2 ="/code";
        int value = 1;
        createPath(input1, value);
        createPath(input, value);
        // getPath(input) ;
    }

    private static int getPath(String filePath) {
       return pathMap.getOrDefault(filePath, -1);
    }

    private static boolean createPath(String filePath, int value) {
        if(validatePath(filePath)){
            String parent = filePath.substring(0,filePath.lastIndexOf("/"));
            if(isParentExists(parent)){
                pathMap.put(filePath, value);
                return true;
            }
            return false;
        }
       return false;
    }

    static boolean validatePath(String path){
        if(path == null || path.equals("") || path.equals("/") || pathMap.containsKey(path)){
            return false;
        }
        return true;
    }
    static boolean isParentExists(final String parent){
        if(parent.length()>1 && !pathMap.containsKey(parent)){
            return false;
        }else{
            return true;
        }
    }


}
