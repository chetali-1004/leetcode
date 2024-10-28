class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        
        for (int num : nums) {
            hs.add(num);
        }
        
        int maxStreak = 0;
        
        // Check each number for square streak
        for (int num : nums) {
            int current = num;
            int streakLength = 0;
            
            while (hs.contains(current)) {
                streakLength++;
                if ((long) current*current > Integer.MAX_VALUE) break;
                current = current * current;
                
            }
            if (streakLength >= 2) {
                maxStreak = Math.max(maxStreak, streakLength);
            }
        }
        return maxStreak == 0 ? -1 : maxStreak;
    }
}
