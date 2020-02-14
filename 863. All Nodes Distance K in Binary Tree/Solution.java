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
 * Runtime: 10 ms, faster than 77.74% of Java online submissions for All Nodes Distance K in Binary Tree.
 * Memory Usage: 38.9 MB, less than 5.26% of Java online submissions for All Nodes Distance K in Binary Tree.
 */
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        buildParentMap(root);
        kDist(target, K, res);
        return res;
    }

    private void kDist(TreeNode node, int k, List<Integer> res) {
        if (node == null)
            return;
        if (visited.contains(node))
            return;
        if (k == 0)
            res.add(node.val);

        visited.add(node);

        kDist(node.left, k - 1, res);
        kDist(node.right, k - 1, res);
        if (parent.containsKey(node)) {
            kDist(parent.get(node), k - 1, res);
        }
    }

    private void buildParentMap(TreeNode node) {
        if (node == null)
            return;
        if (node.left != null) {
            parent.put(node.left, node);
        }
        buildParentMap(node.left);
        if (node.right != null) {
            parent.put(node.right, node);
        }
        buildParentMap(node.right);
    }
}