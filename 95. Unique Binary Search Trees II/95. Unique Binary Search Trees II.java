/**
 * Runtime: 2 ms, faster than 24.79% of Java online submissions for Unique Binary Search Trees II.
 * Memory Usage: 43.1 MB, less than 11.32% of Java online submissions for Unique Binary Search Trees II.
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
    public List<TreeNode> generateTrees(int n) {
        return constructTrees(1, n);
    }

    private List<TreeNode> constructTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = constructTrees(start, i - 1);
            List<TreeNode> rightTrees = constructTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left;
                    newNode.right = right;
                    result.add(newNode);
                }
            }
        }
        return result;
    }
}