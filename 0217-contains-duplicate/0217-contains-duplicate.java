import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            if(hm.getOrDefault(num, 0) >= 2) return true;
        }
        
        return false;
    }
}