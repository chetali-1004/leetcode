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
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int height){
        if(root == null) return height;
        int left = helper(root.left, height+1);
        int right = helper(root.right, height+1);
        return Math.max(left, right);
    }
}