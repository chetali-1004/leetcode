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
        Set<Integer> hs = new HashSet<>();
        for(int r : restricted) hs.add(r);
        if(hs.contains(0)) return 0;
        int count = 0;
        vis[0] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int neigh : adj.get(node)){
                if(vis[neigh]==0){
                    if(hs.contains(neigh)) continue;
                    q.offer(neigh);
                    vis[neigh] = 1;
                }
                
            }
        }
        return count;
    }
}