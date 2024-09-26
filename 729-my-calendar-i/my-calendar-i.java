class MyCalendar {
    Queue<Pair> pq;

    class Pair{
        int s;
        int e;
        public Pair(int s, int e){
            this.s = s;
            this.e = e;
        }
    }

    
    public MyCalendar() {
        pq = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
        Iterator<Pair> it = pq.iterator();
        while(it.hasNext()){
            Pair p = it.next();
            if(p.s < end && p.e > start) return false;
        }
        pq.offer(new Pair(start, end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */