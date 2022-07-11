class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int index = binarySearch(numbers, target - numbers[i], i + 1, numbers.length - 1);
            if (index != -1) {
                return new int[] { i + 1, index + 1};
            }
        }
        return new int[2];
    }
    
    private int binarySearch(int[] numbers, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (target == numbers[mid]) {
            return mid;
        }
        if (numbers[mid] > target) {
            return binarySearch(numbers, target, low, mid - 1);
        } else {
            return binarySearch(numbers, target, mid + 1, high);
        }
    }
}