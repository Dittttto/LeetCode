import java.util.*;
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> essential = new HashMap<>();        
        for(char c: tArr) {
            window.put(c, 0);
            essential.put(c, essential.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int x = 0; 
        int essentialEle = 0;
        while(right < sArr.length) {
            char ch = sArr[right];
            right += 1;
            if(essential.get(ch) != null) {
                window.replace(ch, window.get(ch) + 1);
                if((int)window.get(ch) == (int)essential.get(ch)) {
                    essentialEle += 1;
                }
                
            }
            
            while(essentialEle == essential.size()) {
                if(right - left < minLen) {
                    x = left;
                    minLen = right - left;
                }
                
                char ch2 = sArr[left];
                left += 1;
                
                if(essential.get(ch2) != null) {
                    if((int)window.get(ch2) == (int)essential.get(ch2)) {
                        essentialEle -= 1;
                    }
                    window.replace(ch2, window.get(ch2) - 1);
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(x, x + minLen);
    }
}