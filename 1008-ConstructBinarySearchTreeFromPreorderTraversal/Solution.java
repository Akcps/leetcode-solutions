/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
 * Memory Usage: 35.5 MB, less than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
 */
class Solution {
    TreeNode root = null;
    public TreeNode bstFromPreorder(int[] preorder) {
        for (int val: preorder) {
            TreeNode node = new TreeNode(val);
            if (root == null) {
                root = node;
            } else {
                constructBst(root, node);
            }
        }
        return root;
    }

    private void constructBst(TreeNode root, TreeNode node) {
        if (node.val < root.val) {
            if (root.left == null) {
                root.left = node;
            } else {
                constructBst(root.left, node);
            }
        } else if (node.val > root.val) {
            if (root.right == null) {
                root.right = node;
            } else {
                constructBst(root.right, node);
            }
        }
    }
}