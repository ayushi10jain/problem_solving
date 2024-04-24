package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class WordLadder {
        class Node{
            String word;
            ArrayList<String> listwords;

            public Node(String word){
                this.word = word;
                this.listwords = new ArrayList<String>();
                this.listwords.add(word);
            }

            public Node (String word, ArrayList<String> listwords){
                this.word = word;
                this.listwords = new ArrayList<String>();
                this.listwords.addAll(listwords);
                this.listwords.add(word);
            }
        }
        public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
        {
            ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
            HashSet<String> set = new HashSet<String>();
            for(String s : wordList){
                set.add(s);
            }
            // Code here
            if(startWord == targetWord){
                ArrayList<String> found = new ArrayList<String>();
                ans.add(found);
            }

            if(!set.contains(targetWord)){
                return ans;
            }

            Queue<Node> q = new LinkedList<Node>();
            q.offer(new Node(startWord));

            while(!q.isEmpty()){
                int size = q.size();
                for(int i =0; i<size; i++){
                    Node current = q.poll();
                    String s = current.word;
                    char[] word = s.toCharArray();
                    for(int j =0; j<word.length; j++){
                        char original = word[j];
                        for(char k='a'; k<='z'; k++){
                            word[j] = k;
                            if(String.valueOf(word).equals(targetWord)){
                                Node result = new Node(String.valueOf(word),current.listwords);
                                ans.add(result.listwords);
                            }else if(set.contains(String.valueOf(word))){
                                set.remove(String.valueOf(word));
                                q.add(new Node(String.valueOf(word),current.listwords));
                            }
                        }
                        word[j] = original;
                    }
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        WordLadder sol = new WordLadder();
        sol.findSequences(null,null,null);
    }

}
