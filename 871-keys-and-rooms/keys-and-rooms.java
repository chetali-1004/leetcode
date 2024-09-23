class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.offer(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int front = q.poll();
            for(int neigh : rooms.get(front)){
                if(vis[neigh] == false){
                    vis[neigh] = true;
                    q.offer(neigh);
                }
            }
        }

        for(int i = 0; i<n; i++){
            if(!vis[i]) return false;
        }
        return true;
    }
}