/**
 * Runtime: 3 ms, faster than 75.69% of Java online submissions for Kth Largest Element in an Array.
 * Memory Usage: 40.8 MB, less than 5.18% of Java online submissions for Kth Largest Element in an Array.
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1,n2) -> n1-n2);
        for (int i = 0; i < k; i++)
            minHeap.add(nums[i]);
        for(int i = k; i< nums.length; i++) {
            if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}