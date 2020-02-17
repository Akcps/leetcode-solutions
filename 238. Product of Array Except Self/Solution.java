/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
 * Memory Usage: 47.5 MB, less than 5.51% of Java online submissions for Product of Array Except Self.
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftMultiplication = new int[n];
        leftMultiplication[0] = 1;
        for(int i = 1; i < n; i++) {
            leftMultiplication[i] = leftMultiplication[i - 1] * nums[i - 1];
        }
        int[] rightMultiplication = new int[n];
        rightMultiplication[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--){
            rightMultiplication[i] = rightMultiplication[i + 1] * nums[i + 1];
        }

        for (int i = 0; i <= n - 1; i++) {
            nums[i] = leftMultiplication[i]* rightMultiplication[i];
        }
        return nums;
    }
}