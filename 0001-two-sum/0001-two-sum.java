import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int value = 0;
        int key = 0;
        for(int i = 0;i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.get(nums[i]) == null) {
                map.put(diff, i);
            }else {
                key = i;
                value = map.get(nums[i]);
                break;
            }
        }
        
        return new int[]{key,value};
    }
}