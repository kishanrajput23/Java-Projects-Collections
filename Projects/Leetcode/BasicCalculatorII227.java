/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * Example 1:
 * Input: "3+2*2"
 * Output: 7
 * 
 * Example 2:
 * Input: " 3/2 "
 * Output: 1
 * 
 * Example 3:
 * Input: " 3+5 / 2 "
 * Output: 5
 * 
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */

public class BasicCalculatorII227 {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int N = s.length();
        int res = 0;
        int i = 0;
        while (i < N && chars[i] == ' ') i++;
        int j = getNum(chars, i);
        int num = Integer.valueOf(s.substring(i, j));
        i = j;
        while (i < N) {
            while (i < N && chars[i] == ' ') i++;
            if (i == N) break;
            char op = chars[i];
            i++;
            while (i < N && chars[i] == ' ') i++;
            if (i == N) break;
            j = getNum(chars, i);
            int curr = Integer.valueOf(s.substring(i, j));
            i = j;
            if (op == '+') {
                res += num;
                num = curr;
            } else if (op == '-') {
                res += num;
                num = -curr;
            } else if (op == '*') {
                num *= curr;
            } else {
                num /= curr;
            }
        }
        return res + num;
    }

    private int getNum(char[] chars, int i) {
        int j = i;
        while (j < chars.length && Character.isDigit(chars[j])) {
            j++;
        }
        return j;
    }





}
