class Solution {
    class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    private int n;
    private int distanceThreshold;
    private List<List<Pair>> adj;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        this.n = n;
        this.distanceThreshold = distanceThreshold;
        this.adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        int res = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = dijkstra(i);
            if (count <= minCount) {
                minCount = count;
                res = i;
            }
        }
        return res;
    }

    private int dijkstra(int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> (p1.dist-p2.dist));
        int cnt = 0;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        pq.offer(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair front = pq.poll();
            int u = front.node;
            int wt = front.dist;
            if(wt>dist[u]) continue;
            cnt++;
            for(Pair p : adj.get(u)){
                if(dist[p.node]>wt+p.dist && wt+p.dist<=distanceThreshold){
                    pq.offer(new Pair(p.node, wt+p.dist));
                    dist[p.node]=wt+p.dist;
                }
            }
        }
        return cnt-1;
    }
}