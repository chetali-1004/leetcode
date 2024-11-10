class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[][] dp = new int[days.length][366];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return helper(days, costs, 0, 0, dp);
    }
    private int helper(int[] days, int[] costs, int i, int upto, int[][] dp){
        if(i==days.length) return 0;
        if(days[i]<=upto) return helper(days, costs, i+1, upto, dp);
        if(dp[i][upto]!=-1) return dp[i][upto];
        int onedaypass = costs[0] + helper(days, costs, i+1, days[i], dp);
        int sevendaypass = costs[1] + helper(days, costs, i+1, days[i]+6, dp);
        int thirtydaypass = costs[2] + helper(days, costs, i+1, days[i]+29, dp);
        return dp[i][upto]=Math.min(onedaypass, Math.min(sevendaypass, thirtydaypass));
    }
}