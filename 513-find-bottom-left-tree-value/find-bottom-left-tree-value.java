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
    public int findBottomLeftValue(TreeNode root) {
        return helper(root, new int[]{0,0}, 1);
    }
    private int helper(TreeNode root, int[] res, int depth){
        if(res[1]<depth){
            res[0] = root.val;
            res[1] = depth;
        }
        if(root.left!=null){
            helper(root.left, res, depth+1);
        }
        if(root.right!=null){
            helper(root.right, res, depth+1);
        }
        return res[0];
    }
}