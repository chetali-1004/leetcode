class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] sol = new int[n];
        int allXor = 0;
        for (int num : nums) {
            allXor ^= num;
        }
        
        int maxK = (1 << maximumBit) - 1;
        for (int i = 0; i < n; i++) {
            sol[i] = allXor ^ maxK;
            allXor ^= nums[n - i - 1];
        }

        return sol;
    }
}
