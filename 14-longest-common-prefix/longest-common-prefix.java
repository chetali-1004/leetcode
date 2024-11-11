class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        Trie trie = new Trie();
        for(String str : strs){
            trie.insert(str);
        }

        return trie.search(strs[0], strs.length);
    }
}

class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String str){
        TrieNode node = root;
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node.get(ch).count++;
            node = node.get(ch);
        }
        node.setEnd();
    }

    public String search(String str, int n){
        TrieNode node = root;
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(node.get(ch)!=null && node.get(ch).count == n){
                node = node.get(ch);
            }
            else return str.substring(0,i);
        }
        return str;
    }
}

class TrieNode{
    TrieNode[] arr = new TrieNode[26];
    int count= 0;
    boolean flag = false;
    
    public boolean containsKey(char ch){
        return arr[ch-'a']!=null;
    }

    public TrieNode get(char ch){
        return arr[ch-'a'];
    }

    public void put(char ch, TrieNode node){
        arr[ch-'a'] = node;
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}