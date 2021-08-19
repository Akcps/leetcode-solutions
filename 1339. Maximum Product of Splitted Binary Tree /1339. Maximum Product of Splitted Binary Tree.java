/**
 * Runtime: 12 ms, faster than 26.11% of Java online submissions for Maximum Product of Splitted Binary Tree.
 * Memory Usage: 54.4 MB, less than 84.98% of Java online submissions for Maximum Product of Splitted Binary Tree.
 * Time Complexity: O (N)
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
    List<Integer> sums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        long sum = sumOfTreeNodes(root);
        System.out.println(sum);
        long max = 0;
        for(int s: sums) {
            max = Math.max(max, s * (sum - s));
        }
        return (int)(max % 1000000007);
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