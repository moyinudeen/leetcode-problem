class Solution {
    public int divide(int dividend, int divisor) {
        // Handle integer overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to absolute values using long to prevent overflow
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Perform bitwise long division
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;

            // Shift divisor left until it is larger than the remaining dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest shifted divisor and add multiple to quotient
            absDividend -= tempDivisor;
            quotient += multiple;
        }

        // Apply the determined sign to the final result
        return isNegative ? -quotient : quotient;
    }
}
