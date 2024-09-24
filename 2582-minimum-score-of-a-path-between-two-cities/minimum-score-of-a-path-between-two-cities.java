class Solution {
    class Node{
        int node;
        int dist;
        public Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Node>> adj = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (n1.dist-n2.dist));
        int[] vis = new int[n+1];
        int min = Integer.MAX_VALUE;

        for(int i = 0; i<=n; i++) adj.add(new ArrayList<>());
        for(int[] road : roads){
            adj.get(road[0]).add(new Node(road[1], road[2]));
            adj.get(road[1]).add(new Node(road[0], road[2]));
        }

        pq.offer(new Node(1, Integer.MAX_VALUE));

        while(!pq.isEmpty()){
            Node front = pq.poll();
            int node = front.node;
            int dist = front.dist;
            min = Math.min(min, dist);
            for(Node neigh : adj.get(node)){
                if(vis[neigh.node] == 0){
                    pq.add(new Node(neigh.node,neigh.dist));
                }
            }
            vis[node] = 1;
        }

        return min;
    }
}