/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Equal Tree Partition.
 * Memory Usage: 39.8 MB, less than 74.84% of Java online submissions for Equal Tree Partition.
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
    List<Integer> sums = new ArrayList<>();

    public boolean checkEqualTree(TreeNode root) {
        int totalSum = sumOfTreeNodes(root);
        if (totalSum % 2 != 0) {
            return false;
        }
        sums.remove(sums.size() - 1);
        for (int sum : sums) {
            if (sum == totalSum / 2) {
                return true;
            }
        }
        return false;
    }

    private int sumOfTreeNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumOfTreeNodes(root.left);
        int rightSum = sumOfTreeNodes(root.right);
        int totalSum = leftSum + rightSum + root.val;
        sums.add(totalSum);
        return totalSum;
    }
}