class Solution {
    public String countAndSay(int n) {
        String[] nums = new String[31];
        nums[0] = "";
        nums[1] = "1";
        nums[2] = "11";
        nums[3] = "21";
        nums[4] = "1211";
        if (n <= 4) {
            return nums[n];
        } else {
            for (int i = 5; i <= n; i++) {
                nums[i] = count(nums[i-1]);
            }
            return nums[n];
        }
    }

    public String count(String num) {
        int i = 1;
        int count = 1;
        char current = num.charAt(0);
        String result = "";
        while ( i < num.length()) {
            char ch = num.charAt(i);
            if (ch == current) {
                count++;
            } else {
                result = result + String.valueOf(count);
                result = result + current;
                current = ch;
                count = 1;
            }
            i++;
        }
        result = result + String.valueOf(count);
        result = result + current;
        return result;
    }
}