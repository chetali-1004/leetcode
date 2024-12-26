class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }
    private int helper(int[] nums, int target, int i, int sum){
        if(i==nums.length && sum == target) return 1;
        else if(i == nums.length) return 0;
        int plus = helper(nums, target, i+1, sum+nums[i]);
        int neg = helper(nums, target, i+1, sum-nums[i]);
        return plus+neg;
    }
}