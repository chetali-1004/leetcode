class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return helper(questions, 0, dp);
    }
    private long helper(int[][] questions, int i, long[] dp){
        if(i>=questions.length) return 0;
        if(dp[i]!=-1) return dp[i];
        long skip = helper(questions, i+1, dp);
        long take = questions[i][0] + helper(questions, i+questions[i][1]+1, dp);
        return dp[i] = Math.max(skip, take);
    }
}