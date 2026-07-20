class Solution {
    public boolean isNumber(String s) {
        // Trim whitespace if required, though LeetCode constraints usually handle it
        s = s.trim();
        
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
                
            } else if (c == '+' || c == '-') {
                // Signs can only appear at the very start, or immediately after an exponent 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
                
            } else if (c == '.') {
                // A dot cannot appear after an exponent or another dot
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
                
            } else if (c == 'e' || c == 'E') {
                // An exponent cannot appear twice, and must follow a valid number/decimal component
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset to ensure an integer follows the exponent
                
            } else {
                // Any other character is invalid
                return false;
            }
        }
        
        // The string must end with a valid digit sequence (especially important after 'e' or '.')
        return seenDigit;
    }
}
