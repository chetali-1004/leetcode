class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(helper(nums.length-1, nums, dp), helper(nums.length-2, nums, dp));
    }
    private int helper(int i, int[] nums, int[] dp){
        int total = 0;
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        total += Math.max(nums[i] + helper(i-2, nums, dp), helper(i-1, nums, dp));
        return dp[i] = total;
    }
}