/**
 * Runtime: 4 ms, faster than 72.52% of Java online submissions for Roman to Integer.
 * Memory Usage: 45.3 MB, less than 5.48% of Java online submissions for Roman to Integer.
 */
class Solution {
    public int romanToInt(String s) {
        char [] a = s.toCharArray();
        int result = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] == 'M') result += 1000;
            else if (a[i] == 'D') result += 500;
            else if (a[i] == 'C') {
                if( i+1 < a.length) {
                    if(a[i + 1] == 'D') {
                        result += 400; i++;
                    } else if (a[i + 1] == 'M') {
                        result += 900;
                        i++;
                    } else {
                        result += 100;
                    }
                }
                else {
                    result += 100;
                }
            } else if(a[i] == 'L') {
                result +=50;
            } else if (a[i] == 'X') {
                if(i+1<a.length) {
                    if(a[i+1] == 'L') {
                        result += 40;
                        i++;
                    } else if (a[i+1] == 'C') {
                        result += 90;
                        i++;
                    } else {
                        result += 10;
                    }
                } else {
                    result += 10;
                }
            }
            else if (a[i] == 'V') {
                result += 5;
            } else if (a[i] == 'I') {
                if(i+1 < a.length) {
                    if(a[i + 1] == 'V') {
                        result += 4; i++;
                    } else if (a[i + 1] == 'X') {
                        result += 9;
                        i++;
                    } else {
                        result += 1;
                    }
                } else {
                    result += 1;
                }
            }
        }
        return result;
    }

}