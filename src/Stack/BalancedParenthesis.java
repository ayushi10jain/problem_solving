package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BalancedParenthesis {
    public static void main(String[] args) {
        //String str = "({})[";
        //String str = "({})[()";
        String str = "()[{}";
        String curr = "";
        String prev = "";
        List<String> result = new ArrayList();
        Stack<Character> s= new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                if(!curr.isEmpty() ){
                    result.add(curr);
                    prev = "";
                    curr = "";
                }
                s.push(c);
                continue;
            }
            else {
                if(s.empty()){
                   if(!curr.isEmpty() ){
                       result.add(curr);
                   }
                }
                else if(!s.empty()){
                    char top = s.pop();
                    if(top == '(' && c == ')'){
                        if(!curr.isEmpty()){
                            prev = curr;
                            curr = "";
                        }
                        curr = top + prev + c;
                      continue;
                    }else if(top == '{' && c == '}'){
                        if(!curr.isEmpty()){
                            prev = curr;
                            curr = "";
                        }
                        curr = top + prev + c;
                        continue;
                    }else if(top == '[' && c == ']'){
                        if(!curr.isEmpty()){
                            prev = curr;
                            curr = "";
                        }
                        curr = top + prev + c;
                        continue;
                    }
                    if(!curr.isEmpty()){
                            result.add(curr);
                        curr = "";
                        }

                }
            }
        } // for
        if(!curr.isEmpty()){
            result.add(curr);
        }
        System.out.println(result);

    } // main
}// class
