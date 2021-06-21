/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Read N Characters Given Read4.
 * Memory Usage: 37.1 MB, less than 52.19% of Java online submissions for Read N Characters Given Read4.
 */

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int count = 0;
        int readChars = 4;
        char[] buf4 = new char[4];

        while (count < n && readChars == 4) {
            readChars = read4(buf4);
            for (int i = 0; i < readChars && count < n; i++) {
                buf[count] = buf4[i];
                count++;
            }
        }
        return count;
    }
}