class Solution {
    public int lengthOfLastWord(String s) {
        // Remove trailing spaces
        s = s.trim();
        
        // Find the index of the last space character
        int lastSpaceIndex = s.lastIndexOf(' ');
        
        // The length is the difference between total length and the last space index
        return s.length() - 1 - lastSpaceIndex;
    }
}
