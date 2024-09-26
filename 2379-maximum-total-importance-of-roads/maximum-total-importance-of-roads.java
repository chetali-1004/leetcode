class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        long ans = 0;

        for(int i = 0; i<roads.length; i++){
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }
        Arrays.sort(degree);

        for(int i = n-1; i>=0; i--){
            ans += (long)((i+1)*(long)degree[i]);
        }
        return ans;
    }
}