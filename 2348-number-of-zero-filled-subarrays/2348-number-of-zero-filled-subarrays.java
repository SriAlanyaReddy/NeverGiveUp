class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, result = 0;
        for (int num : nums) {
            if (num == 0) {
                count++; // extend current zero subarray
                result += count; // add all subarrays ending here
            } else {
                count = 0; // reset if not zero
            }
        }
        return result;
    }
}