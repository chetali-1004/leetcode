class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> ls = new ArrayList<>();
        int[] sol = new int[queries.length];
        for(int i = 0; i<n; i++){
            ls.add(new ArrayList<>());
        }
        for(int i = 0; i<n-1; i++){
            ls.get(i).add(i+1);
        }
        int i = 0;
        for(int[] query : queries){
            ls.get(query[0]).add(query[1]);
            sol[i++] = bfs(0, n-1, ls, n);
        }
        return sol;
    }
    private int bfs(int src, int dest, List<List<Integer>> ls, int n){
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.offer(src);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neigh : ls.get(curr)){
                if(dist[neigh]>dist[curr]+1){
                    dist[neigh] = dist[curr] + 1;
                    q.offer(neigh);
                }
            }
        }
        return dist[dest];
    }
}