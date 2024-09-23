class Solution {
    class Pair {
        long node;
        long time;
        public Pair(long time, long node) {
            this.node = node;
            this.time = time;
        }
    }
    
    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9+7);
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            int n1 = road[0];
            int n2 = road[1];
            int time = road[2];
            adj.get(n1).add(new Pair(time, n2));
            adj.get(n2).add(new Pair(time, n1));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Long.compare(p1.time, p2.time));
        long[] numOfWays = new long[n];
        long[] dist = new long[n];
        numOfWays[0] = 1;
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair front = pq.poll();
            long node = front.node;
            long time = front.time;
            if(time>dist[(int)node]) continue;
            for(Pair neigh : adj.get((int)node)){
                if(dist[(int)neigh.node] > neigh.time + dist[(int)node]){
                    dist[(int)neigh.node] = neigh.time + dist[(int)node];
                    pq.offer(new Pair(dist[(int)neigh.node], neigh.node));
                    numOfWays[(int)neigh.node] = numOfWays[(int)node];
                }
                else if(dist[(int)neigh.node] == neigh.time + dist[(int)node]){
                    numOfWays[(int)neigh.node] = (numOfWays[(int)neigh.node] + numOfWays[(int)node])%mod;
                }
            }
        }
        return (int)(numOfWays[n-1]%mod);
    }
}