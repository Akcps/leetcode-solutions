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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
 * Memory Usage: 39.8 MB, less than 74.88% of Java online submissions for Validate Binary Search Tree.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max)
            return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
}