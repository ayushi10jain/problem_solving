package arrays;

import java.util.ArrayList;
import java.util.List;


public class FunctionProgram {

        public static void main(String[] argv) {
            String[] words1 = {"The","day","began","as","still","as","the","night","abruptly","lighted","with","brilliant","flame"};
            String[] words2 = {"Hello"};
            String[] words3 = {"Hello", "Hello"};
            String[] words4 = {"Well", "Hello", "world"};
            String[] words5 = {"Hello", "HelloWorld", "Hello", "Hello"};
            String[] words6 = {"a", "b", "c", "d"};
            List<String> resultLines = wrapLines(words1, 13);
            System.out.println("output");
            for(int i=0; i<resultLines.size(); i++){
                System.out.println(resultLines.get(i));
            }
        }

        public  static List<String> wrapLines(String[] words, int target){
            int finalTarget = target;
            List<String> resultLines = new ArrayList<String>();
            String currentLine = "";
            for(int i=0; i<words.length;){
                String word1 = words[i];
                if(word1.length()<=target){
                    String currentword = "";
                    currentword = word1+"-";
                    currentLine = currentLine +currentword;
                    target = target-currentword.length();
                    System.out.println("currentLine in if" + currentLine);
                    System.out.println("target in if" + target);
                    i++;

                }else{
                    System.out.println("currentLine in else" + currentLine);
                    if(currentLine.length()>0){
                        System.out.println("currentLine length" + currentLine.length());
                        currentLine = currentLine.substring(0,currentLine.length()-1);
                    }
                    System.out.println("currentLine in else :::::" + currentLine);
                    resultLines.add(currentLine);
                    target = finalTarget;
                    currentLine = "";
                }


            }
            if(currentLine.length()>0){
                System.out.println("currentLine length" + currentLine.length());
                currentLine = currentLine.substring(0,currentLine.length()-1);
            }
            System.out.println("currentLine in else :::::" + currentLine);
            resultLines.add(currentLine);
            return resultLines;

        }


}
