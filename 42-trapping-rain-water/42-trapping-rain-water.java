class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxHeight = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, arr[i]);
            left[i] = maxHeight;
        }
        maxHeight = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            maxHeight = Math.max(maxHeight, arr[i]);
            right[i] = maxHeight;
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            sum += min - arr[i];
        }
        return sum;
    }
}