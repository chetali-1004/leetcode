class Solution {
    class Pair{
        int node;
        int val;
        public Pair(int node, int val){
            this.node = node;
            this.val = val;
        }
    }
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = vals.length;
        long res = Long.MIN_VALUE;

        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i<n; i++){
            List<Integer> curr = adj.get(i);
            curr.sort((a,b) -> (vals[b]-vals[a]));
            long sum = vals[i];
            long max = vals[i];
            for(int j = 0; j<k && j<curr.size(); j++){
                sum += vals[curr.get(j)];
                max = Math.max(max, sum);
            }
            res = Math.max(res, max);
        }
        return (int)res;
    }
}