/**
 * Runtime: 76 ms, faster than 61.66% of Java online submissions for Shuffle an Array.
 * Memory Usage: 47.1 MB, less than 91.94% of Java online submissions for Shuffle an Array.
 * Time Complexity: O (N) The Fisher-Yates algorithm runs in linear time, as generating a random index
 * and swapping two values can be done in constant time.
 * Space Complexity: O (N)
 */
class Solution {
    private int[] originalArray;
    private Random rand;

    public Solution(int[] nums) {
        originalArray = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArray;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = originalArray.clone();
        for (int i = 0; i < originalArray.length; i++) {
            int randomIndex = rand.nextInt(originalArray.length - i) + i; // rand.nextInt(max - min) + min;
            int temp = res[i];
            res[i] = res[randomIndex];
            res[randomIndex] = temp;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */