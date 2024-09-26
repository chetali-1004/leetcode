class MyCalendar {
    Map<Integer, Integer> mp;
    public MyCalendar() {
        mp = new HashMap<>();
    }
    
    public boolean book(int start, int end) {
        for(Integer s : mp.keySet()){
            if(s<end && mp.get(s)>start) return false;
        }
        mp.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */