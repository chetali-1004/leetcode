class Solution {
    class Pair{
        int num;
        int freq;
        public Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2) -> p2.freq-p1.freq);
        Map<Integer, Integer> mp = new HashMap<>();
        int[] sol = new int[k];
        for(int i = 0; i<nums.length; i++){
            if(mp.containsKey(nums[i])){
                mp.put(nums[i], mp.get(nums[i])+1);
            }
            else mp.put(nums[i], 1);
        }
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        while(k>0){
            sol[k-1] = pq.poll().num;
            k--;
        }
        return sol;
    }
}