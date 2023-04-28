import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sHm = new HashMap<>();
        HashMap<Character, Integer> tHm = new HashMap<>();
        
        for(char ch: t.toCharArray()){
            tHm.put(ch, tHm.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch: s.toCharArray()){
            if(tHm.get(ch) == null) return false;
            tHm.put(ch, tHm.get(ch) - 1);
        }
        
        for(Map.Entry<Character, Integer> entry :tHm.entrySet()) {
            if(entry.getValue() != 0) return false;
        }

        return true;
    }
}