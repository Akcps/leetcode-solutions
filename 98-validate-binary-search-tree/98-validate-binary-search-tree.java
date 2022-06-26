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
    public boolean isValidBST(TreeNode root) {
        return isBst(root, null, null);
    }
    
    private boolean isBst(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        
        boolean left = isBst(node.left, min, node.val);
        boolean right = isBst(node.right, node.val, max);
        
        if (!right || !left) {
            return false;
        }
        
        if (((min != null && node.val <=  min)  || (max != null && node.val >= max))) {
            return false;
        }
        return true;
        
    }
}