class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost.length-1, cost, dp), helper(cost.length-2, cost, dp));
    }
    private int helper(int i, int[] cost, int[] dp){
        if(i<0) return 0;
        if(i==0 || i== 1) return dp[i]=cost[i];
        if(dp[i]!=-1) return dp[i];
        return dp[i]=cost[i] + Math.min(helper(i-1, cost, dp), helper(i-2, cost, dp));
    }
}