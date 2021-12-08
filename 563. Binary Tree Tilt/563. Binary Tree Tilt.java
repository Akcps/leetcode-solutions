/**
 * Runtime: 1 ms, faster than 38.44% of Java online submissions for Binary Tree Tilt.
 * Memory Usage: 42.6 MB, less than 19.78% of Java online submissions for Binary Tree Tilt.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int sum = 0;

    public int findTilt(TreeNode root) {
        calc(root);
        return sum;
    }

    private int calc(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calc(root.left);
        int right = calc(root.right);
        int diff = Math.abs(left - right);
        sum += diff;
        int value = root.val + left + right;
        return value;
    }
}