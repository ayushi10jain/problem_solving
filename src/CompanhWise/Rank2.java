package CompanhWise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Rank2 {
    static Map<Character, int[]> hm = new HashMap();

    public static void main(String[] args) {
       // String[] s = { "ABC", "ACB", "ABC", "ACB", "ACB" };
        String[] s1 = { "WXYZ","XYZW" };
       // String answer = getAnswer(s);
       // System.out.println(answer);
        String answer1 = getAnswer(s1);
        System.out.println(answer1);

    }

    private static String getAnswer(final String[] s) {
        int n = s[0].length();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < n; j++) {
                char c = s[i].charAt(j);
                if (!hm.containsKey(c)) {
                    hm.put(c, new int[n]);
                }
                int[] count = hm.get(c);
                count[j]++;
                hm.put(c, count);
            }
        }

       return getFinalAnswer(hm, n);
    }

    private static String getFinalAnswer(final Map<Character,int[]> hm, int n) {
        List<Character> keys = new ArrayList(hm.keySet());
        Collections.sort(keys, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (hm.get(b)[i] != hm.get(a)[i]) {
                    return hm.get(b)[i] - hm.get(a)[i];}
            }
            return 0;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            sb.append(keys.get(i));
        }
        return sb.toString();
        }

}
