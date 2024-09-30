class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] c : connections){
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(-c[0]);
        }
        return dfs(0, adj, new int[n]);
    }
    private int dfs(int node, List<List<Integer>> adj, int[] vis){
        int change = 0;
        vis[node] = 1;
        for(int neigh : adj.get(node)){
            if(vis[Math.abs(neigh)]==0){
                change += dfs(Math.abs(neigh), adj, vis) + (neigh>0 ? 1 : 0);
            }
        }
        return change;
    }
}