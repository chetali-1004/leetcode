class Solution {
    class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1==node2) return node1;
        int n = edges.length;
        int[] dist1 = bfs(edges, node1);
        int[] dist2 = bfs(edges, node2);
        int ans = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] == Integer.MAX_VALUE || dist2[i] == Integer.MAX_VALUE) continue;

            int maxDist = Math.max(dist1[i], dist2[i]);

            // Update if maxDist is smaller or if we found a smaller index with the same maxDist
            if (maxDist < minDist) {
                minDist = maxDist;
                ans = i;
            } else if (maxDist == minDist && i < ans) {
                ans = i;
            }
        }
        return ans;
    }
    private int[] bfs(int[] edges, int src){
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p1.dist-p2.dist);
        pq.offer(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair front = pq.poll();
            int node = front.node;
            int d = front.dist;
            int neigh = edges[node];
            if(neigh == -1) continue;
            if(dist[neigh]>d+1){
                dist[neigh] = d+1;
                pq.offer(new Pair(neigh, dist[neigh]));
            }
        }
        return dist;
    }
}