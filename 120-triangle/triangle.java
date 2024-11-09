class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int[] arr : dp) Arrays.fill(arr, -1);
        return helper(triangle, 0,0, dp);
    }
    private int helper(List<List<Integer>> triangle, int i, int j, int[][] dp){
        if(i==triangle.size()-1) return triangle.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=triangle.get(i).get(j) + Math.min(helper(triangle, i+1, j, dp), helper(triangle, i+1, j+1, dp));
    }
}