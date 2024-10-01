class Solution {
    public int findChampion(int[][] grid) {
        
        int strongestSum = 0;
        int strongestTeam = -1;

        for(int i = 0; i < grid.length; i++){
            int sum = 0;
            for (int j = 0; j < grid[0].length; j++){
                sum+= grid[i][j];
                if(sum > strongestSum){
                    strongestSum = sum;
                    strongestTeam = i;
                }
            }
        }

        return strongestTeam;
    }
}