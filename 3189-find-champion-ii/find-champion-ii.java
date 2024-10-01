class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        int count = 0;
        int ans = -1;

        for(int[] edge : edges){
            indegree[edge[1]]++;
        }
        for(int i = 0; i<n; i++){
            if(indegree[i]==0) {
                count++;
                ans = i;
            }
            if(count>1) return -1;
        }
        return ans;
    }
}