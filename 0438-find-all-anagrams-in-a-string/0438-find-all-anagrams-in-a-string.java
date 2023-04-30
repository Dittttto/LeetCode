import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        HashMap<Character, Integer> essential = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(char c: pArr) {
            essential.put(c, essential.getOrDefault(c, 0)+1);
            window.put(c, 0);
        }
        
        int left = 0;
        int right = 0;
        int essentialValid = 0;
        while(right < sArr.length){
            char ch = sArr[right];
            right++;
            
            if(essential.get(ch) != null) {
                window.replace(ch, window.get(ch) + 1);
                if((int)window.get(ch) == (int)essential.get(ch)) {
                    essentialValid += 1;
                }
            }
            
            while(essentialValid == essential.size()){
                char ch2 = sArr[left];
                left++;
                
                if(essential.get(ch2) != null) {
                    if(right - left + 1 == pArr.length) {
                        list.add(left - 1);
                    }
                    
                    if((int)window.get(ch2) == (int)essential.get(ch2)) {
                        essentialValid -= 1;
                    }

                    window.replace(ch2, window.get(ch2) - 1);
                }
            }
        }
        return list;
    }
}