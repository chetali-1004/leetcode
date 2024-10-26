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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root,0);
        return ans;
    }
    private int helper(TreeNode root, int dia){
        if(root == null) return 0;
        int left = helper(root.left, dia+1);
        int right = helper(root.right, dia+1);
        ans = Math.max(ans, left+right);
        return 1+Math.max(left,right); 
    }
}