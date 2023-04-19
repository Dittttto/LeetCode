class Solution {
    int[] dp = new int[10001];
    public int coinChange(int[] coins, int amount) {
        if(amount > 0 && dp[amount] != 0) return dp[amount];
        if(amount == 0) return 0;
        if(amount < 0) return -1;

        int result = Integer.MAX_VALUE;
        for(int coin: coins) {
            int tmp = coinChange(coins, amount - coin);
            if(tmp == -1) continue;
            result = Math.min(result, tmp + 1);
        }

        dp[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return dp[amount];
    }
}