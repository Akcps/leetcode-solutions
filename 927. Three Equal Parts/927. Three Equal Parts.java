/**
 * Runtime: 2 ms, faster than 87.50% of Java online submissions for Three Equal Parts.
 * Memory Usage: 45 MB, less than 55.77% of Java online submissions for Three Equal Parts.
 * Time Complexity: O (n)
 * Space Complexity : O (1)
 */

class Solution {
    public int[] threeEqualParts(int[] arr) {
        int[] res = new int[] {-1, -1};

        int count1s = 0;
        for (int a: arr) {
            count1s += a;
        }

        if (count1s == 0) {
            return new int[] {0, 2};
        }

        if (count1s % 3 != 0) {
            return res;
        }

        int numOf1sInEachPart = count1s / 3;
        int firstIndex = -1;
        int secondIndex = -1;
        int thirdIndex = -1;

        count1s = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count1s++;
                if (count1s == 1) {
                    firstIndex = i;
                } else if (count1s ==  numOf1sInEachPart + 1) {
                    secondIndex = i;
                } else if (count1s == 2 * numOf1sInEachPart + 1) {
                    thirdIndex = i;
                }
            }

        }

        while (thirdIndex < arr.length) {
            if (arr[firstIndex] == arr[secondIndex] && arr[secondIndex] == arr[thirdIndex]) {
                firstIndex++;
                secondIndex++;
                thirdIndex++;
            } else {
                return res;
            }
        }
        return new int[] {firstIndex - 1, secondIndex};

    }
}