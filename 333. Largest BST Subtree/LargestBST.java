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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest BST Subtree.
 * Memory Usage: 40.8 MB, less than 25.00% of Java online submissions for Largest BST Subtree.
 * Time Complexity; O(n)
 * Space Complexity: O(n)
 */
class Solution {
    int maxSize = 0;
    public int largestBSTSubtree(TreeNode root) {
        findLargestBST(root);
        return maxSize;
    }

    private SizeMinMax findLargestBST(TreeNode node) {
        if (node == null) {
            return new SizeMinMax(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        SizeMinMax left = findLargestBST(node.left);
        SizeMinMax right = findLargestBST(node.right);

        if (node.val > left.max && node.val < right.min && left.size >= 0 && right.size >= 0) {
            int newSize = left.size + right.size + 1;
            maxSize = Math.max(newSize, maxSize);

            int newMin = Math.min(left.min, Math.min(right.min, node.val));
            int newMax = Math.max(left.max, Math.max(right.max, node.val));

            return new SizeMinMax(newMin, newMax, newSize);
        } else {
            return new SizeMinMax(node.val, node.val, -1);
        }
    }


    class SizeMinMax {
        int min;
        int max;
        int size;
        public SizeMinMax(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
}