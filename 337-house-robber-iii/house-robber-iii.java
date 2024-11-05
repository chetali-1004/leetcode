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
    private HashMap<TreeNode, Integer> dp;
    public int rob(TreeNode root) {
        dp = new HashMap<>();
        return helper(root);
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        if(dp.containsKey(root)) return dp.get(root);
        int rob = root.val;
        if(root.left!=null){
            rob += helper(root.left.left) + helper(root.left.right);
        }
        if(root.right!=null){
            rob += helper(root.right.left) + helper(root.right.right);
        }

        int notRob = helper(root.left) + helper(root.right);
        int res = Math.max(rob, notRob);
        dp.put(root, res);
        return res;
    }
}