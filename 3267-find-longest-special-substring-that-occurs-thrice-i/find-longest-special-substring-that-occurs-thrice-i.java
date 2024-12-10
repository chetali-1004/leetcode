class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> mp = new HashMap<>();
        int n = s.length();
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                StringBuilder sb = new StringBuilder();
                for(int k = i; k<=j; k++) sb.append(s.charAt(k));
                Set<Character> hs = new HashSet<>();
                for(int c = 0; c<sb.length(); c++){
                    hs.add(sb.charAt(c));
                }
                if(hs.size()==1) mp.put(sb.toString(), mp.getOrDefault(sb.toString(),0)+1);
            }
        }

        int max = -1;
        for(Map.Entry<String, Integer> entry: mp.entrySet()){
            if(entry.getValue()>=3) max = Math.max(max, entry.getKey().length());
        }
        return max;
    }
}