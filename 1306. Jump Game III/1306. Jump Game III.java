/**
 * Runtime: 6 ms, faster than 39.64% of Java online submissions for Jump Game III.
 * Memory Usage: 46.7 MB, less than 88.94% of Java online submissions for Jump Game III.
 */

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (arr[index] < 0) {
                continue;
            }
            if (arr[index] == 0) {
                return true;
            }
            if (index + arr[index] < n) {
                queue.add(index + arr[index]);
            }
            if (index - arr[index] >= 0) {
                queue.add(index - arr[index]);
            }
            arr[index] = -arr[index];
        }
        return false;
    }
}