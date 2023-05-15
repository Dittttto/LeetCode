class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i< nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }
        
        int result = dp[0];
        System.out.println(Arrays.toString(dp));
        for(int num: dp) {
            result = Math.max(result, num);
        }
        
        return result;
    }
}