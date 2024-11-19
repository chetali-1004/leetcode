class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        Set<Integer> hs = new HashSet<>();
        long sum = 0;
        long maxsum = 0;

        int i = 0;
        for (int j = 0; j < n; j++) {
            while (hs.contains(nums[j]) || hs.size() >= k) {
                hs.remove(nums[i]);
                sum -= nums[i];
                i++;
            }
            hs.add(nums[j]);
            sum += nums[j];
            if (hs.size() == k) {
                maxsum = Math.max(maxsum, sum);
            }
        }

        return maxsum;
    }
}