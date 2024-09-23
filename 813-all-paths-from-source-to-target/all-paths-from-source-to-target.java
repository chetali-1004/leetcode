class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> sol = new ArrayList<>();
        int n = graph.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(graph, temp, sol, 0, n-1);
        return sol;
    }
    private void dfs(int[][] graph, List<Integer> ls, List<List<Integer>> sol, int curr, int dest){
        if(curr == dest){
            sol.add(new ArrayList<>(ls));
            return;
        }

        for(int node : graph[curr]){
            ls.add(node);
            dfs(graph, ls, sol, node, dest);
            ls.remove(ls.size()-1);
        }
    }
}