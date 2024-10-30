class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] indegree = new int[n];
        for(int i = 0; i<n; i++){
            if(leftChild[i]!=-1){
                indegree[leftChild[i]]++;
            }
            if(rightChild[i]!=-1){
                indegree[rightChild[i]]++;
            }
        }

        //finding root:
        int root = -1;
        for(int i = 0; i<n; i++){
            if(indegree[i] == 0){
                if(root!=-1) return false;
                root = i;
            }
        }
        if(root == -1) return false;
        boolean[] vis = new boolean[n];
        boolean dfsEval = dfs(root, leftChild, rightChild, vis);
        if(!dfsEval) return false;
        for(boolean v : vis){
            if(!v) return false;
        }
        return true;
        
    }
    private boolean dfs(int node, int[] left, int[] right, boolean[] vis){
        if(vis[node]) return false; //cycle detected
        vis[node] = true;
        if(left[node]!=-1 && !dfs(left[node], left, right, vis)) return false;
        if(right[node]!=-1 && !dfs(right[node], left, right, vis)) return false; 
        return true;
    }
}