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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 * Memory Usage: 36.2 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> res = new LinkedList<>();
        int level=1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> curLevelList = new LinkedList<>();
            int n = queue.size();
            for(int i = 0; i < n; i++){
                TreeNode cur = queue.poll();

                if(level % 2 == 1)
                    curLevelList.add(cur.val);
                else
                    curLevelList.add(0, cur.val);

                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
            res.add(curLevelList);
            level++;
        }
        return res;
    }
}

/**
 * Solution based on 2 stacks
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

/**
 * Runtime: 1 ms, faster than 75.24% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 * Memory Usage: 38.7 MB, less than 87.02% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 */
class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> tempStack = new Stack<>();
        tempStack.push(root);
        boolean leftToRight = true;
        while(!tempStack.isEmpty()) {
            int size = tempStack.size();
            List<Integer> currentList = new ArrayList<>();
            stack = tempStack;
            tempStack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                currentList.add(node.val);
                if (!leftToRight) {
                    if (node.right != null) {
                        tempStack.push(node.right);
                    }
                    if (node.left != null) {
                        tempStack.push(node.left);
                    }
                } else {
                    if (node.left != null) {
                        tempStack.push(node.left);
                    }
                    if (node.right != null) {
                        tempStack.push(node.right);
                    }
                }
            }
            result.add(currentList);
            leftToRight = !leftToRight;

        }
        return result;
    }
}