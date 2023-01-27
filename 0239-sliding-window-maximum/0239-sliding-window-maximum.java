class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0;
        int maxIdx = 0;
        while (start != k) {
            keepValidEnteries(start, k, deque, nums);
            deque.addLast(start);
            if (nums[start] > nums[maxIdx]) {
                maxIdx = start;
            }
            start++;
        }
        result[0] = nums[maxIdx];
        for (int i = start; i < nums.length; i++){
            keepValidEnteries(i, k, deque, nums);
            deque.addLast(i);
            result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }
    
    // You want to ensure the deque window only has decreasing elements. That way, the leftmost element is always the largest.
    private void keepValidEnteries(int i, int k, Deque<Integer> deque, int[] nums) {
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            deque.removeLast();
        }
        
    }
}