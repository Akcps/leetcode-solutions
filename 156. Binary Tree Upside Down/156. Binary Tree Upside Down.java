/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Upside Down.
 * Memory Usage: 36.8 MB, less than 33.94% of Java online submissions for Binary Tree Upside Down.
 */
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        return dfs(root);
    }

    private TreeNode dfs (TreeNode current) {
        if (current.left == null) {
            return current;
        }
        TreeNode newNode = dfs(current.left);
        current.left.left = current.right;
        current.left.right = current;
        current.left = null;
        current.right = null;
        return newNode;
    }
}