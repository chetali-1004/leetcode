class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        int[][] dp = new int[n][n+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        for(int i = 0; i<n; i++){
            arr[i][0] = scores[i]; 
            arr[i][1] = ages[i];
        }
        Arrays.sort(arr, (a,b)-> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]);
        return helper(arr, 0, -1, dp);
    }
    private int helper(int[][] arr, int i, int prev, int[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int take = Integer.MIN_VALUE;
        if(prev==-1 || arr[i][0]>=arr[prev][0]){
            take = arr[i][0] + helper(arr, i+1, i, dp);
        }
        int notTake = helper(arr, i+1, prev, dp);
        return dp[i][prev+1] = Math.max(take, notTake);
    }
}