class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0], b[0]);
        });
        for(int i = 0; i<nums.length; i++){
            pq.offer(new int[]{nums[i], i});
        }
        while(k-->0){
            int[] top = pq.poll();
            pq.offer(new int[]{top[0]*multiplier, top[1]});
        }

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            nums[top[1]] = top[0];
        }
        return nums;
    }
}