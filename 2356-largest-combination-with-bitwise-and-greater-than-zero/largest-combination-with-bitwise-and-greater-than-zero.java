class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitarr = new int[24];
        int n = candidates.length;
        int max = 0;

        for(int i = 0; i<n; i++){
            int k = 0;
            int val = candidates[i];
            while(val>0){
                bitarr[k] += (val&1);
                val /= 2;
                max = Math.max(max, bitarr[k]);
                k++;
            }
        }
        return max;
    }
}