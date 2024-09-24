class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] team = new int[n+1];

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] dislike : dislikes) {
            adj.get(dislike[0]).add(dislike[1]);
            adj.get(dislike[1]).add(dislike[0]); 
        }

        Arrays.fill(team, -1); 

        // Perform BFS for every unvisited node
        for (int i = 1; i <= n; i++) {
            if (team[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                team[i] = 0; 

                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int neigh : adj.get(node)) {
                        if (team[neigh] == -1) {
                            team[neigh] = 1 - team[node]; 
                            q.offer(neigh);
                        } else {
                            if (team[neigh] == team[node]) return false; 
                        }
                    }
                }
            }
        }

        return true;
    }
}
