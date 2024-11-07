class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(helper(0, nums.length-2, nums, dp1), helper(1, nums.length-1, nums, dp2));
    }
    private int helper(int i, int n, int[] nums, int[] dp){
        if(n<i) return 0;
        if(dp[n]!=-1) return dp[n]; 
        return dp[n] = Math.max(nums[n]+helper(i, n-2, nums, dp), helper(i, n-1, nums, dp));
    }
}