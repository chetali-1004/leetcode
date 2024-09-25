class Trie {
    Trie[] arr = new Trie[26];
    int count = 0;
}

class Solution {
    Trie root = new Trie();

    public int[] sumPrefixScores(String[] words) {
        for(String word : words){
            insert(word);
        }
        int[] ans = new int[words.length];
        for(int i = 0; i<words.length; i++){
            ans[i] = getVal(words[i]);
        }
        return ans;
    }

    private void insert(String str) {
        Trie curr = root;
        for (int i = 0; i < str.length(); i++) {
            if (curr.arr[str.charAt(i) - 'a'] == null) {
                curr.arr[str.charAt(i) - 'a'] = new Trie();
            }
            curr = curr.arr[str.charAt(i) - 'a'];
            curr.count++;
        }
    }

    private int getVal(String str){
        Trie curr = root;
        int cnt = 0;
        for(char ch : str.toCharArray()){
            if(curr.arr[ch-'a'] == null) return cnt;
            curr = curr.arr[ch-'a'];
            cnt += curr.count;
        }
        return cnt;
    }
}