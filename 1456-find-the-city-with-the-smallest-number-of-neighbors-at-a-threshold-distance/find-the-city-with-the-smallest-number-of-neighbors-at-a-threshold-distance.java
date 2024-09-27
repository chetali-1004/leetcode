class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj = new int[n][n];
        int[] numOfCities = new int[n];
        int city = -1;
        int maxCity = n+1;

        for(int[] arr : adj) Arrays.fill(arr, (int)1e8);
        for(int[] edge : edges){
            adj[edge[0]][edge[1]] = edge[2];
            adj[edge[1]][edge[0]] = edge[2];
        }
        for(int i = 0; i<n; i++) adj[i][i] = 0;
        
        for(int via = 0; via<n; via++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(adj[i][via] == (int)1e8 || adj[via][j] == (int)1e8) continue;
                    adj[i][j] = Math.min(adj[i][j], adj[i][via] + adj[via][j]);
                }
            }
        }

        for(int i = 0; i<n; i++){
            int cnt = 0;
            for(int j = 0; j<n; j++){
                if(adj[i][j]<=distanceThreshold) cnt++;
            }
            if(cnt<=maxCity){
                maxCity = cnt;
                city = i;
            }
        }
        return city;
    }
}