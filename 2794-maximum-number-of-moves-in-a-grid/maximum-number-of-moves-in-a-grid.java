class Solution {
    public int maxMoves(int[][] grid) {
        int moves = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        for(int i = 0; i<n; i++){
            moves = Math.max(moves, helper(grid, i, 0, n, m, -1, dp));
        }
        return moves-1;
    }
    private int helper(int[][] grid, int i, int j, int n, int m, int curr, int[][] dp){
        if(i>=n || i<0 || j>=m || j<0 || grid[i][j]<=curr) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j]=Math.max((helper(grid,i-1,j+1,n,m,grid[i][j], dp)+1),Math.max((helper(grid,i,j+1,n,m,grid[i][j],dp)+1),(helper(grid,i+1,j+1,n,m,grid[i][j],dp)+1)));
    }
}