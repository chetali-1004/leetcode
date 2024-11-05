class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int time = dfs(0, -1, adj, hasApple);
        return (time>0) ? time-2 : 0;
    }

    private int dfs(int curr, int prev, List<List<Integer>> adj, List<Boolean> hasApple){
        int ans = 0;
        for(int neigh : adj.get(curr)){
            if(neigh!=prev){
                ans += dfs(neigh, curr, adj, hasApple);
            }
        }
        return (ans > 0 || hasApple.get(curr)) ? ans+2 : 0;
    }
}