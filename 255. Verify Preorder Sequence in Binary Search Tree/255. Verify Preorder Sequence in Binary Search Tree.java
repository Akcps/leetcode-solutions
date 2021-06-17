/**
 * Runtime: 8 ms, faster than 43.09% of Java online submissions for Verify Preorder Sequence in Binary Search Tree.
 * Memory Usage: 39.2 MB, less than 92.35% of Java online submissions for Verify Preorder Sequence in Binary Search Tree.
 */

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int prev = -1;
        for (int val: preorder) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && val > stack.peek()) {
                    prev = stack.pop();
                }
            }
            if (prev > val) {
                return false;
            }
            stack.add(val);
        }
        return true;
    }
}