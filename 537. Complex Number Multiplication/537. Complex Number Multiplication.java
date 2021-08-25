/**
 * Runtime: 3 ms, faster than 92.34% of Java online submissions for Complex Number Multiplication.
 * Memory Usage: 37.5 MB, less than 58.76% of Java online submissions for Complex Number Multiplication.
 * Time Complexity = O( len(num1) + len(num2))
 */
class Solution {

    private class ComplexNo {
        private int real;
        private int imaginary;

        public ComplexNo(int rNo, int iNo) {
            this.real = rNo;
            this.imaginary = iNo;
        }
    }

    public String complexNumberMultiply(String num1, String num2) {
        ComplexNo no1 = parseNo(num1);
        ComplexNo no2 = parseNo(num2);

        int rProductNo = (no1.real * no2.real) - (no1.imaginary * no2.imaginary);
        int iProductNo = (no1.imaginary * no2.real) + (no1.real * no2.imaginary);

        String ans = rProductNo + "+" + iProductNo + "i";
        return ans;

    }

    private ComplexNo parseNo(String no) {
        int i = 0;
        int rNo = 0;
        boolean isNegReal = false;
        if (no.charAt(i) == '-') {
            isNegReal = true;
            i++;
        }
        while (no.charAt(i) != '+') {
            rNo = 10 * rNo + (no.charAt(i) - '0');
            i++;
        }
        if (isNegReal) {
            rNo = -1 * rNo;
        }
        i++;
        boolean isNegImg = false;
        if (no.charAt(i) == '-') {
            isNegImg = true;
            i++;
        }
        int iNo = 0;
        while (no.charAt(i) != 'i') {
            iNo = 10 * iNo + (no.charAt(i) - '0');
            i++;
        }
        if (isNegImg) {
            iNo = -1 * iNo;
        }

        return new ComplexNo(rNo, iNo);
    }
}