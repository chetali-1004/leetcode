class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> mp = new HashMap<>();
        int ind = 0;
        for(List<String> ls : equations){
            if(!mp.containsKey(ls.get(0))){
                mp.put(ls.get(0), ind++);
            }
            if(!mp.containsKey(ls.get(1))){
                mp.put(ls.get(1), ind++);
            }
        }

        int n = ind;
        double[][] dist = new double[n][n];
        for(double[] d : dist) Arrays.fill(d, Double.MAX_VALUE);

        ind = 0;
        for(List<String> ls : equations){
            int u = mp.get(ls.get(0));
            int v = mp.get(ls.get(1));
            double val = values[ind++];
            dist[u][v] = val;
            dist[v][u] = 1/val;
        }

        for(int via = 0; via<n; via++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(i!=via && j!=via){
                        if(dist[i][via]!=Double.MAX_VALUE && dist[via][j]!=Double.MAX_VALUE){
                            dist[i][j] = Math.min(dist[i][j], dist[i][via] * dist[via][j]);
                        }
                    }
                }
            }
        }

        double[] sol = new double[queries.size()];
        ind = 0;
        for(List<String> q : queries){
            if(mp.containsKey(q.get(0)) && mp.containsKey(q.get(1))){
                int u = mp.get(q.get(0));
                int v = mp.get(q.get(1));
                double val = dist[u][v];
                if(val == Double.MAX_VALUE){
                    sol[ind++] = -1.0;
                }
                else{
                    sol[ind++] = val;
                }
            }
            else{
                sol[ind++] = -1.0;
            }
        }
        return sol;
    }   
}