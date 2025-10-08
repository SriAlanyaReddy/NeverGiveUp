class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;

        // Continue until only one element remains
        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10; // replace each with sum mod 10
            }
            n--; // array effectively shrinks by one
        }

        return nums[0]; // final remaining element is the triangular sum
    }
}
