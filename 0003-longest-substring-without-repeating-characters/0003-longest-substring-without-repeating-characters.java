import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c: arr) window.put(c, 0);
        
        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        while(right < arr.length) {
            char ch = arr[right];
            right++;
            window.replace(ch, window.get(ch) + 1);
            
            while(window.get(ch) > 1) {
                char ch2 = arr[left];
                left++;
                
                window.replace(ch2, window.get(ch2) - 1);
            }
            maxLen = Math.max(right - left, maxLen);
        
        }
        
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}