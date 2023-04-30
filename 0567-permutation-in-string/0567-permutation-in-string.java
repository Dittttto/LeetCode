import java.util.*;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        HashMap<Character, Integer> essential = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c: s1Arr) {
            essential.put(c, essential.getOrDefault(c, 0) + 1);
            window.put(c, 0);
        }
        
        int left = 0;
        int right = 0;
        int essentialValid = 0;
        while(right < s2Arr.length){
            char ch = s2Arr[right];
            right++;
            
            if(essential.get(ch) != null) {
                window.replace(ch, window.get(ch)+1);
                if((int)window.get(ch) == (int)essential.get(ch)){
                    essentialValid += 1;
                }
            }
            
            while(essentialValid == essential.size()) {
                System.out.println(right + " : " + left);
                char ch2 = s2Arr[left];
                left++;
                if(essential.get(ch2) != null) {
                    System.out.println(ch2 + " : " + (int)essential.get(ch2) + " : " + (int)window.get(ch2));
                    System.out.println(right - left + 1 == essential.size());
                    if(right - left + 1 == s1Arr.length) {
                        return true;
                    }
                    if((int)window.get(ch2) == (int)essential.get(ch2)){
                        essentialValid -= 1;
                    }
                    window.replace(ch2, window.get(ch2) - 1);
                }
            }
        }
        return false;
    }
}