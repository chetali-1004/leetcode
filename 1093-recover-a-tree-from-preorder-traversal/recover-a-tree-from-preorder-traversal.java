/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Map<Integer, TreeNode> mp = new HashMap<>();
        int pos = 0;
        TreeNode root = null;
        while(pos < traversal.length()){
            int depth = 0;
            while(pos<traversal.length() && traversal.charAt(pos)=='-'){
                depth++;
                pos++;
            }
            
            StringBuilder sb = new StringBuilder();
            while(pos<traversal.length() && traversal.charAt(pos)!='-'){
                sb.append(traversal.charAt(pos));
                pos++;
            }
            int nodeVal = Integer.valueOf(sb.toString());
            if(depth == 0) {
                root = new TreeNode(nodeVal);
                mp.put(0, root);
                continue;
            }
            TreeNode parent = mp.get(depth-1);
            TreeNode curr = new TreeNode(nodeVal);
            if(parent.left==null) parent.left = curr;
            else parent.right = curr;
            mp.put(depth, curr);
        }
        return root;
    }
}