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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
 * Memory Usage: 40.9 MB, less than 5.19% of Java online submissions for Diameter of Binary Tree.
 */
class Solution {
    int diameter = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;

    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        diameter = Math.max(diameter, lh + rh + 1);
        return Math.max(lh, rh) + 1;
    }


}