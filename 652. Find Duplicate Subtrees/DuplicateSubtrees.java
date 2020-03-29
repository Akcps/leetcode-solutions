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
 * Runtime: 13 ms, faster than 89.43% of Java online submissions for Find Duplicate Subtrees.
 * Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Find Duplicate Subtrees.
 */
class Solution {
    int counter = 1;
    Map<String, Integer> trees = new HashMap<>();
    Map<Integer, Integer> count = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        find(root);
        return ans;
    }

    public int find(TreeNode node) {
        if (node == null) {
            return 0;
        }
        String serial = node.val + "," + find(node.left) + "," + find(node.right);
        int uid = trees.computeIfAbsent(serial, x-> counter++);
        count.put(uid, count.getOrDefault(uid, 0) + 1);
        if (count.get(uid) == 2) {
            ans.add(node);
        }
        return uid;
    }
}