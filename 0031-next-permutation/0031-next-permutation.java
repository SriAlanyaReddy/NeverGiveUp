import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int start = -1;

        // Step 1: Find the first decreasing element from the right
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                start = i;
                break;
            }
        }

        if (start != -1) {
            // Step 2: Find the smallest element greater than nums[start] from the right
            int end = -1;
            for (int i = n - 1; i > start; i--) {
                if (nums[i] > nums[start]) {
                    end = i;
                    break;
                }
            }
            // Step 3: Swap the two elements
            swap(nums, start, end);
        }

        // Step 4: Reverse the sublist after start
        reverse(nums, start + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
