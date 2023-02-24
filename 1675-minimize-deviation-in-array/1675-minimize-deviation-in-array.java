class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> evens = new PriorityQueue<>(Collections.reverseOrder());
        int minimum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 0) {
                evens.offer(num);
                minimum = Math.min(minimum, num);
            } else {
                evens.offer(num * 2);
                minimum = Math.min(minimum, num * 2);
            }
        }
        int minDeviation = Integer.MAX_VALUE;

        while (!evens.isEmpty()) {
            int currentValue = evens.poll();
            minDeviation = Math.min(minDeviation, currentValue - minimum);
            if (currentValue % 2 == 0) {
                evens.offer(currentValue / 2);
                minimum = Math.min(minimum, currentValue / 2);
            } else {
                // if the maximum is odd, break and return
                break;
            }
        }
        return minDeviation;
    }
}