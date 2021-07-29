/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Longest Consecutive Sequence II.
 * Memory Usage: 38.6 MB, less than 93.34% of Java online submissions for Binary Tree Longest Consecutive Sequence II.
 * Time Complexity: O(N)
 * Space Complexity: O(N)
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
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        getLongestConsecutive(root);
        return max;
    }

    private int[] getLongestConsecutive(TreeNode root) {
        // returns [longest_decreasing_length_from_root, longest_increasing_length_from_root]
        if (root == null) return new int[]{0, 0};
        int[] left = getLongestConsecutive(root.left);
        int[] right = getLongestConsecutive(root.right);
        int dcr = 1, icr = 1;
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                icr = left[1] + 1;
            }
            if (root.left.val == root.val - 1) {
                dcr = left[0] + 1;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                icr = Math.max(icr, right[1] + 1);
            } if (root.right.val == root.val - 1) {
                dcr = Math.max(dcr, right[0] + 1);
            }
        }
        max = Math.max(max, dcr + icr - 1);
        return new int[]{dcr, icr};
    }

}

