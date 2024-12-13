class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        int[] marked = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            if(a[0]==b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        long score = 0;
        Arrays.fill(marked, -1);
        for(int i = 0; i<n; i++){
            pq.offer(new int[]{nums[i], i});
        }
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            if(marked[top[1]]==1) continue;
            score+=top[0];
            marked[top[1]]=1;
            if(top[1]-1>=0) marked[top[1]-1]=1;
            if(top[1]+1<n) marked[top[1]+1]=1;
        }
        return score;
    }
}