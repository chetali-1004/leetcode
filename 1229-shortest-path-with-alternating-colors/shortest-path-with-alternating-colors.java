class Solution {
    class Pair {
        int node;
        int edgeColor;
        public Pair(int node, int edgeColor) {
            this.node = node;
            this.edgeColor = edgeColor;
        }
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] red : redEdges) {
            adj.get(red[0]).add(new Pair(red[1], 1));
        }

        for (int[] blue : blueEdges) {
            adj.get(blue[0]).add(new Pair(blue[1], 0));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        boolean[][] visited = new boolean[n][2];
        visited[0][0] = visited[0][1] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, -1));

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int node = current.node;
                int lastEdgeColor = current.edgeColor;

                for (Pair neighbor : adj.get(node)) {
                    int nextNode = neighbor.node;
                    int edgeColor = neighbor.edgeColor;

                    if (lastEdgeColor == edgeColor) continue;

                    if (!visited[nextNode][edgeColor]) {
                        visited[nextNode][edgeColor] = true;
                        queue.offer(new Pair(nextNode, edgeColor));
                        dist[nextNode] = Math.min(dist[nextNode], level);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
