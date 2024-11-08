class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()+1];
        Arrays.fill(dp, null);
        return helper(s, wordDict, 0, dp);
    }
    private boolean helper(String s, List<String> wordDict, int i, Boolean[] dp){
        if(i==s.length()) return true;
        if(dp[i]!=null) return dp[i];
        for(int j = 0; j<wordDict.size(); j++){
            String word = wordDict.get(j);
            if(s.startsWith(word,i)){
                dp[i] = true;
                if(helper(s, wordDict, i+word.length(), dp)) return true;
            }
        }
        dp[i] = false;
        return false;
    }
}