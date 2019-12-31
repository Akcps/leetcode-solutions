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
 * Runtime: 2 ms, faster than 99.76% of Java online submissions for Maximum Binary Tree.
 * Memory Usage: 38.4 MB, less than 91.30% of Java online submissions for Maximum Binary Tree.
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    public TreeNode buildTree(int[] nums, int low, int high) {
        if (low == high)
            return null;
        int rootInd = maxIndex(nums, low, high);
        TreeNode node = new TreeNode(nums[rootInd]);
        node.left = buildTree(nums, low, rootInd);
        node.right = buildTree(nums, rootInd+1, high);
        return node;
    }

    public int maxIndex(int[]nums, int low, int high) {
        int maxInd = low;
        for (int i = low; i<high; i++) {
            if (nums[i] > nums[maxInd]) {
                maxInd = i;
            }
        }
        return maxInd;
    }
}