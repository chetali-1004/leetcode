class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        long count = 0;
        int min = nums[0];
        int max = nums[0];

        while(j<n){
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);
            if(Math.abs(min-max)<=2){
                count+=(j-i+1);
                j++;
            }
            else{
                if(nums[i]==min || nums[i]==max){
                    i++;
                    min = Integer.MAX_VALUE;
                    max = Integer.MIN_VALUE;
                    for(int k = i; k<=j; k++){
                        min = Math.min(min, nums[k]);
                        max = Math.max(max, nums[k]);
                    }
                }
                else{
                    i++;
                }
            }
        }
        return count;
    }
}