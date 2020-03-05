/**
 * Time Complexity: O(log _{3} n)
 */
class TernarySearch {

    private static int ternarySeach(int[] nums, int low, int high, int element) {
        if (high >= low) {
            int mid1 = low + (high - 1) / 3;
            int mid2 = high - (high - 1) / 3;

            if (nums[mid1] == element) {
                return mid1;
            }

            if (nums[mid2] == element) {
                return mid2;
            }

            if (element < nums[mid1]) {
                return ternarySeach(nums, low, mid1 - 1, element);
            } else if (element > nums[mid2]) {
                return ternarySeach(nums, mid2 + 1, high, element);
            } else {
                return ternarySeach(nums, mid1 + 1, mid2 - 1, element);
            }
        }
        return -1;
    }


    public static void main(String args[]) {
        int[] nums = new int[] { 3, 10, 30, 50, 80, 100, 120, 150, 180, 220 };
        int element = 100;
        int index = ternarySeach(nums, 0, nums.length, element);
        System.out.println(index);
    }
}