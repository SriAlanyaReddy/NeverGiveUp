class Solution {
    public int maxDistance(int[] a1, int[] a2) {
        int left = 0;   // Pointer for array a1 (nums1)
        int right = 0;  // Pointer for array a2 (nums2)
        int max = 0; // To keep track of the maximum distance found

        int n1 = a1.length, n2 = a2.length;

        // Use two pointers to find the farthest valid (i, j) pairs
        while (left < n1 && right < n2) {

            // Check if the current pair (left, right) is valid
            if (a1[left] <= a2[right]) {
                // Valid pair found: a1[left] <= a2[right] and left <= right
                // Update the max distance if it's greater than the current max
                max = Math.max(max, right - left);

                // Try moving right forward to check for a bigger distance
                right++;
            } else {
                // If current pair is not valid (a1[left] > a2[right]),
                // move left forward to find a smaller value in a1
                left++;

                // Ensure that left is not ahead of right (as i <= j is required)
                if (left > right) {
                    right = left;
                }
            }
        }

        return max;
    }
}
