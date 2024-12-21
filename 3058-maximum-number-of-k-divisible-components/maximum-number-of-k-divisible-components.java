class Solution {
    private int count = 0;
    private static int val = -1;

    private int dfs(List<List<Integer>> adj, int curr, int[] values, int k, int parent){
        val = values[curr];
        for(int temp : adj.get(curr)){
            if(temp!=parent){
                val+=dfs(adj, temp, values, k, curr);
            }
        }
        if(val%k==0) count++;
        return val%k;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(adj, 0, values, k, -1);
        return count;
    }
}