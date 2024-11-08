class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(nums, 0, -1, dp);
    }
    private int helper(int[] nums, int i, int prevIndex, int[][] dp){
        if(i==nums.length) return 0;
        if(dp[i][prevIndex+1]!=-1) return dp[i][prevIndex+1];
        int take = 0;
        if(prevIndex==-1 || nums[i]>nums[prevIndex]){
            take = 1+helper(nums, i+1, i, dp);
        }
        int nottake = helper(nums, i+1, prevIndex, dp);
        return dp[i][prevIndex+1] = Math.max(take, nottake);
    }
}