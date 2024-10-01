class Solution {
    public boolean canArrange(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return false;
        
        int[] remainderCounts = new int[k];
        
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) remainder += k;
            remainderCounts[remainder]++;
        }
        
        for (int i = 1; i <= k / 2; i++) {
            if (remainderCounts[i] != remainderCounts[k - i]) {
                return false;
            }
        }
        
        return remainderCounts[0] % 2 == 0;
    }
}
