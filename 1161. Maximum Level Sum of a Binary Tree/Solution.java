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
 * Runtime: 8 ms, faster than 90.12% of Java online submissions for Maximum Level Sum of a Binary Tree.
 * Memory Usage: 40.6 MB, less than 100.00% of Java online submissions for Maximum Level Sum of a Binary Tree.
 */
class Solution {
    int maxLevel = 0, maxSum = 0;

    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return -1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            level++;
            for(int i = 0; i < size; i++) {
                TreeNode polled = q.poll();
                sum += polled.val;
                if (polled.left != null) {
                    q.add(polled.left);
                }
                if (polled.right != null) {
                    q.add(polled.right);
                }
            }
            if (maxSum < sum) {
                maxSum = sum;
                maxLevel = level;
            }
        }
        return maxLevel;
    }
}