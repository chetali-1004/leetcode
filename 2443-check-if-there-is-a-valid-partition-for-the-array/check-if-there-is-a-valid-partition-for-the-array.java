class Solution {
    public boolean validPartition(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        Arrays.fill(dp, null);
        return helper(0, nums, dp);
    }
    private boolean helper(int i, int[] nums, Boolean[] dp){
        if(i>=nums.length) return true;
        if(dp[i]!=null) return dp[i];
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        if(i+1<nums.length && nums[i]==nums[i+1]){
            flag1 = helper(i+2, nums, dp);
        }
        if(i+2<nums.length && nums[i]==nums[i+1] && nums[i+1]==nums[i+2]){
            flag2 = helper(i+3, nums, dp);
        }
        if(i+2<nums.length && nums[i]+1==nums[i+1] && nums[i+1]+1==nums[i+2]){
            flag3 = helper(i+3, nums, dp);
        }
        return dp[i]=flag1 || flag2 || flag3;
    }
}