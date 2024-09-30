class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> mp = new HashMap<>();
        for(int i = 0; i<equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            if(!mp.containsKey(u)){
                mp.put(u, new HashMap<>());
            }
            if(!mp.containsKey(v)){
                mp.put(v, new HashMap<>());
            }
            mp.get(u).put(v,values[i]);
            mp.get(v).put(u,1/values[i]);
        }

        double[] sol = new double[queries.size()];
        for(int i = 0; i<queries.size(); i++){
            sol[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), mp);
        }
        return sol;
    }

    private double dfs(String src, String dest, Set<String> vis, Map<String, Map<String, Double>> mp){
        if(!mp.containsKey(src)) return -1.0;
        if(mp.get(src).containsKey(dest)){
            return mp.get(src).get(dest);
        }
        vis.add(src);
        for(Map.Entry<String, Double> neigh : mp.get(src).entrySet()){
            if(!vis.contains(neigh.getKey())){
                double weight = dfs(neigh.getKey(), dest, vis, mp);
                if(weight!=-1.0) return neigh.getValue()*weight;
            }
        }
        return -1.0;
    }
}