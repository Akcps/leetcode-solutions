/**
 * Runtime: 1 ms, faster than 33.24% of Java online submissions for Maximum Average Subtree.
 * Memory Usage: 42.7 MB, less than 11.54% of Java online submissions for Maximum Average Subtree.
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
    double maxAvg = 0;

    public double maximumAverageSubtree(TreeNode root) {
        averageSubtree(root);
        return maxAvg;
    }

    private int[] averageSubtree(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = averageSubtree(root.left);
        int[] right = averageSubtree(root.right);
        int totalSum = left[0] + right[0] + root.val;
        int totalCount = left[1] + right[1] + 1;
        double avg = totalSum / (double) totalCount;
        maxAvg = Math.max(maxAvg, avg);
        return new int[]{totalSum, totalCount};
    }
}