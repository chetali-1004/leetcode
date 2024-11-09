class Solution {
    private int ans;
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        ans = Integer.MAX_VALUE;
        return helper(n, dp);
    }
    private int helper(int n, int[] dp){
        if(n<=0) return 0;
        if(dp[n]!=-1) return dp[n];
        for(int i = 1; i<=Math.sqrt(n); i++){
            ans = Math.min(ans, 1+helper(n-(i*i), dp));
        }
        return dp[n] = ans;
    }
}