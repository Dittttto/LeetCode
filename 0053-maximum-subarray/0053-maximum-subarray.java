class Solution {
    public int maxSubArray(int[] nums) {
        int dp0 = nums[0];
        int dp1 = 0;
        int result = dp0;
        for(int i = 1; i< nums.length; i++) {
            dp1 = Math.max(nums[i], dp0 + nums[i]);
            dp0 = dp1;
            result = Math.max(result, dp1);
        }
        return result;
    }
}