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
    List<String> ls;
    StringBuilder sb;
    public int sumNumbers(TreeNode root) {
        ls = new ArrayList<>();
        sb = new StringBuilder();
        helper(root);
        int sum = 0;
        for(int i = 0; i<ls.size(); i++){
            System.out.println(Integer.parseInt(ls.get(i)));
        }
        for(int i = 0; i<ls.size(); i++){
            sum += Integer.parseInt(ls.get(i));
        }
        return sum;

    }

    private void helper(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right==null){
            sb.append(root.val);
            ls.add(sb.toString());
            sb.setLength(sb.length()-1);
            return;
        }
        sb.append(root.val);
        helper(root.left);
        helper(root.right);
        sb.setLength(sb.length()-1);
    }
}