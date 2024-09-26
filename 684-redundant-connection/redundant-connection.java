class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
        
        for(int[] edge : edges){
            if(!mp.containsKey(edge[0])){
                mp.put(edge[0], new ArrayList<>());
            }
            if(!mp.containsKey(edge[1])){
                mp.put(edge[1], new ArrayList<>());
            }
            mp.get(edge[0]).add(edge[1]);
            mp.get(edge[1]).add(edge[0]);
            int[] vis = new int[edges.length+1];
            if(dfs(edge[0], -1, mp, vis)) return edge;
        }
        return new int[]{edges[0][0]};
    }

    private boolean dfs(int node, int parent, Map<Integer, ArrayList<Integer>> mp, int[] vis){
        vis[node] = 1;
        for(int neigh : mp.get(node)){
            if(vis[neigh]==0){
                dfs(neigh, node, mp, vis);
            }
            else if(neigh!=parent) return true;
        }
        return false;
    }
}