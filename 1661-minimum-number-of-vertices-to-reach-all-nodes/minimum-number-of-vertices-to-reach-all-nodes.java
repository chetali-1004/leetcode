class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int indegree[] = new int[n];
        for(int i = 0; i<edges.size(); i++){
            indegree[edges.get(i).get(1)]++;
        }
        List<Integer> sol = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(indegree[i]==0){
                sol.add(i);
            }
        }
        return sol;
    }
}