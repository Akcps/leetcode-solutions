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
    int minDiff = Integer.MAX_VALUE;
    TreeNode prevValue;
    
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return minDiff;
        
    }
    
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);

        if (prevValue != null) {
            minDiff = Math.min(minDiff, root.val - prevValue.val);
        }
        
        prevValue = root;

        inOrder(root.right);
        }
}