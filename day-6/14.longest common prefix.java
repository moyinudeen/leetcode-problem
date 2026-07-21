class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if the array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Start by assuming the first string is the entire common prefix
        String prefix = strs[0];
        
        // Compare the prefix with every other string in the array
        for (int i = 1; i < strs.length; i++) {
            // Shorten the prefix until strs[i] starts with it
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}
