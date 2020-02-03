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
 * Runtime: 2 ms, faster than 99.53% of Java online submissions for Vertical Order Traversal of a Binary Tree.
 * Memory Usage: 38.7 MB, less than 6.67% of Java online submissions for Vertical Order Traversal of a Binary Tree.
 */
class Solution {
    List<NodeLocation> locations = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0, 0);
        Collections.sort(locations);
        result.add(new ArrayList<>());
        int prev = locations.get(0).x;
        for (NodeLocation l: locations) {
            if (l.x != prev) {
                prev = l.x;
                result.add(new ArrayList<>());
            }
            result.get(result.size() - 1).add(l.val);
        }
        return result;
    }

    private void dfs(TreeNode node, int x, int y) {
        if (node != null) {
            locations.add(new NodeLocation(node.val, x, y));
            dfs(node.left, x - 1, y + 1);
            dfs(node.right, x + 1, y + 1);
        }
    }

    class NodeLocation implements Comparable<NodeLocation>{
        int val;
        int x;
        int y;

        public NodeLocation(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(NodeLocation nl) {
            if (this.x != nl.x)
                return Integer.compare(this.x, nl.x);
            else if (this.y != nl.y)
                return Integer.compare(this.y, nl.y);
            else
                return Integer.compare(this.val, nl.val);
        }
    }
}