class Solution {
    private Map<String, Boolean> mp = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<>(wordDict);
        return helper(s, hs);
    }

    private boolean helper(String s, Set<String> hs){
        if(s.isEmpty()) return true;
        if(mp.containsKey(s)) return mp.get(s);
        for(int i = 1; i<=s.length(); i++){
            String substr = s.substring(0,i);
            if(hs.contains(substr)){
                mp.put(substr, true);
                if(helper(s.substring(i), hs)) return true;
            }
        }
        mp.put(s, false);
        return false;
    }
}