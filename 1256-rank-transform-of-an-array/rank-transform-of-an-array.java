class Solution {
    class Pair{
        int num;
        int ind;
        public Pair(int num, int ind){
            this.num = num;
            this.ind = ind;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2)->p1.num-p2.num);
        int rank = 1;
        // int[] sol = new int[n];

        for(int i= 0; i<n; i++){
            pq.offer(new Pair(arr[i], i));
        }

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            arr[top.ind] = rank;
            if(!pq.isEmpty() && pq.peek().num == top.num){
                continue;
            }
            rank++;
        }
        return arr;
    }
}