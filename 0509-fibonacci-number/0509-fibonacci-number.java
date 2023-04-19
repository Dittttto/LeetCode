class Solution {
    int[] memo = new int[31];
    public int fib(int n) {
        if(memo[n] != 0) return memo[n];
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        memo[n] = fib(n-1) + fib(n-2);
        return memo[n];
    }
}