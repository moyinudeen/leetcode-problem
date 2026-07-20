class Solution {
    public int[] shuffle(int[] nums, int n) {
        // Create a result array of size 2n
        int[] result = new int[2 * n];
        
        // Loop through the first half of the array
        for (int i = 0; i < n; i++) {
            // Place x_i at the even position
            result[2 * i] = nums[i];
            // Place y_i at the odd position
            result[2 * i + 1] = nums[i + n];
        }
        
        return result;
    }
}
