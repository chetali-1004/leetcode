class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<manager.length; i++){
            if(i!=headID){
                adj.get(manager[i]).add(i);
            }
        }

        return helper(headID, -1, adj, informTime);
    }   

    private int helper(int curr, int prev, List<List<Integer>> adj, int[] informTime){
        int time = 0;
        for(int neigh : adj.get(curr)){
            if(curr!=prev){
                time = Math.max(time,helper(neigh, curr, adj, informTime));
            }
        }
        time+=informTime[curr];
        return time;
    }
}