import java.util.*;
class Solution {    
    public int presentation(int[] nums) {
        Arrays.sort(nums);
        if(nums.length <= 1) return nums.length;
        
        int answer = 0;
        int cnt = 1;
        for(int i = 1; i < nums.length; i++) {
            if((nums[i] - nums[i-1]) == 1) {
                cnt++;
            }else if(nums[i] == nums[i-1]){
                continue;
            }else {
                answer = Math.max(answer, cnt);
                cnt = 1;
            }
        }
        
        if(cnt != 0) {
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
    
    public int longestConsecutive(int[] nums) {
        return presentation(nums);
    }
}