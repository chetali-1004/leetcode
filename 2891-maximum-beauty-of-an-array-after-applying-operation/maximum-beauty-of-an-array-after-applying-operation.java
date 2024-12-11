class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if(nums.length==1) return 1;
        int maxValue = 0;
        int currSum = 0;
        int maxBeauty = 0;
        for(int num : nums){
            maxValue = Math.max(num, maxValue);
        }
        int[] count = new int[maxValue+1];
        for(int num : nums){
            count[Math.max(num-k, 0)]++;
            count[Math.min(num+k+1, maxValue)]--;
        }

        for(int val : count){
            currSum += val;
            maxBeauty = Math.max(maxBeauty, currSum);
        }
        return maxBeauty;
    }
}