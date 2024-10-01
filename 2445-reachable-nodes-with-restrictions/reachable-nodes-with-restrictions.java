class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); 
        }
        int[] vis = new int[n];
        int count = 0;
        for(int i = 0; i<restricted.length; i++){
            vis[restricted[i]] = 1;
        }
        if(vis[0]==1) return 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int neigh : adj.get(node)){
                if(vis[neigh]==0){
                    q.offer(neigh);
                    vis[neigh] = 1;
                }
            }
        }
        return count;
    }
}