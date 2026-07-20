class Solution {
    public int myAtoi(String s) {
        int INT_MIN = Integer.MIN_VALUE;
        int INT_MAX = Integer.MAX_VALUE;

        // Step 1: Remove leading spaces
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        // Step 2: Check sign
        int sign = 1;
        int index = 0;

        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        // Step 3: Convert digits
        int result = 0;

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check overflow
            if (result > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            index++;
        }

        return sign * result;
    }
}
