import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> q = new LinkedList<>();
        char[] arr = s.toCharArray();
        for(char c: arr) {
            if(c == '(' || c == '{' || c == '['){
                q.offerLast(c);
            }else {
                if(q.isEmpty()){
                    return false;
                }else {
                    if(!check(q.peekLast(), c)){
                        return false;
                    }else {
                        q.pollLast();
                    }
                }
            }
        }
        
        return q.size() == 0 ? true : false;
    }
    
    public boolean check(char l, char s) {
        switch(l) {
            case '(': {return s == ')';}
            case '{': {return s == '}';}
            default: {return s == ']';}
        }
    }
}