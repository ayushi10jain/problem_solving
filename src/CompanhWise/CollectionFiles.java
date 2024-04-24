package CompanhWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class CollectionFiles {
    public static int totalSize = 0;
    public static void main(String[] args) {
        InputFile inputFile1 = new InputFile(100 ,"file1");
        InputFile inputFile2 = new InputFile(150 ,"file2", Arrays.asList("collection1", "collection2"));
        InputFile inputFile3 = new InputFile(160 ,"file3", Arrays.asList("collection1", "collection2"));
        InputFile inputFile4 = new InputFile(160 ,"file3", Arrays.asList("collection2", "collection3"));
        List<InputFile> inputFileList= new ArrayList();
        inputFileList.add(inputFile1);
        inputFileList.add(inputFile2);
        inputFileList.add(inputFile3);
        inputFileList.add(inputFile4);
        Map<String, Integer> hm = storeCollections(inputFileList);
        getTotalSize();
        topKCollections(hm, 2);
    }

    private static  Map.Entry<String,Integer> [] topKCollections(Map<String, Integer> hm, int k) {
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                }
                return o1.getKey().compareTo(o2.getKey());
            }
        });


        for(Map.Entry<String,Integer> map : hm.entrySet()){
            pq.add(map);
            if(pq.size() > k){
                pq.remove();
            }
        }

        Map.Entry<String,Integer> [] topK = new Map.Entry[pq.size()];

        for(int i=pq.size()-1; i>=0; i--){
            topK[i] = pq.remove();
        }
        return topK;
    }

    private static Map<String,Integer> storeCollections(List<InputFile> inputFileList) {
        Map<String,Integer> collectioNmap = new HashMap();
        for(InputFile inputFile : inputFileList){
            File file = createFile(inputFile.getFile(), inputFile.getSize());
            if(inputFile.getCollection()!=null) {
                for (String collection : inputFile.getCollection())
                    if (!collectioNmap.containsKey(collection)) {
                        collectioNmap.put(collection, file.size);
                    } else {
                        int size = collectioNmap.get(collection);
                        collectioNmap.put(collection, size + file.size);
                    }
            }
        }
return collectioNmap;
    }

    private static File createFile(String filename, int size) {
        totalSize = totalSize + size;
        File file = new File(filename, size);
        return file;
    }

    private static int getTotalSize() {
        return totalSize;
    }
}
