class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-->0){
            int i = 0;
            for(int j = 1; j<nums.length; j++){
                if(nums[j]<nums[i]){
                    i = j;
                }
            }
            nums[i] = nums[i]*multiplier;
        }
        return nums;
    }
}