class Solution {
    Trie root = new Trie();

    class Trie{
        Trie[] arr = new Trie[10];
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = Integer.MIN_VALUE;
        Trie curr = root;
        for(int a: arr1){
            insert(a);
        }

        for(int a : arr2){
            int len = search(a);
            ans = Math.max(ans, len);
        }
        return ans;
    }

    private void insert(int i){
        Trie curr = root;
        String str = String.valueOf(i);
        char[] ch = str.toCharArray();
        for(int j = 0; j<ch.length; j++){
            if(curr.arr[ch[j]-'0'] == null){
                curr.arr[ch[j]-'0'] = new Trie();
            }
            curr = curr.arr[ch[j]-'0'];
        }
    }
    
    private int search(int i){
        int len = 0;
        Trie curr = root;
        String str = String.valueOf(i);
        char[] ch = str.toCharArray();
        for(int j = 0; j<ch.length; j++){
            if(curr.arr[ch[j]-'0'] == null){
                break;
            }
            len++;
            curr = curr.arr[ch[j]-'0'];
        }
        return len;
    }
}