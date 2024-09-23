class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> sol = new ArrayList<>();
        int dest = graph.length-1;
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        q.offer(temp);
        while(!q.isEmpty()){
            List<Integer> front = q.poll();
            if(front.get(front.size()-1) == dest) sol.add(front);
            else{
                for(int neigh : graph[front.get(front.size()-1)]){
                    List<Integer> path = new ArrayList<>(front);
                    path.add(neigh);
                    q.offer(path);
                }
            }
        }
        return sol;
    }
}