class Solution {
    class Pair{
        int[] point;
        double dist;
        public Pair(int[] point, double dist){
            this.point = point;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] sol = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair p1, Pair p2) -> Double.compare(p1.dist, p2.dist));
        for(int[] point : points){
            pq.offer(new Pair(point, Math.sqrt(Math.pow(point[0],2) + Math.pow(point[1],2))));
        }
        for(int i = 0; i<k; i++){
            sol[i] = pq.poll().point;
        }
        return sol;
    }
}