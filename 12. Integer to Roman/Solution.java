/**
 * Runtime: 4 ms, faster than 77.92% of Java online submissions for Integer to Roman.
 * Memory Usage: 44 MB, less than 5.00% of Java online submissions for Integer to Roman.
 */
class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int i=num;
        while( i > 0) {
            if (i >= 1000) {
                i -= 1000;
                result.append("M");
            } else if ( i >= 900) {
                i -= 900;
                result.append("CM");
            } else if (i >= 500) {
                i -= 500;
                result.append("D");
            } else if ( i >= 400) {
                i -= 400;
                result.append("CD");
            } else if (i >= 100) {
                i -= 100;
                result.append("C");
            } else if ( i >= 90) {
                i -= 90;
                result.append("XC");
            } else if (i >= 50) {
                i -= 50;
                result.append("L");
            } else if ( i >= 40) {
                i -= 40;
                result.append("XL");
            } else if (i >= 10) {
                i -= 10;
                result.append("X");
            } else if (i == 9) {
                i -= 9;
                result.append("IX");
            } else if (i >= 5) {
                i -= 5;
                result.append("V");
            } else if (i == 4) {
                i -= 4;
                result.append("IV");
            } else if(i <= 3) {
                result.append("I");
                i--;
            } else {
                i--;
            }
        }

        return result.toString();
    }
}