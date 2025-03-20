class Solution {
    public int findMin(int[] a) {
        int low = 0;
        int high = a.length - 1;

        while (low < high) {  // Continue searching while the range is valid
            int mid = low + (high - low) / 2; // Calculate mid to prevent integer overflow
            
            // If the array is already sorted (not rotated), return the first element
            if (a[low] < a[high]) { 
                return a[low];
            }
            
            // If the left half is unsorted, the minimum must be in the left half
            if (a[low] > a[mid]) {
                high = mid; // Move high to mid, as mid could be the minimum
            }
            // If the right half is unsorted, the minimum must be in the right half
            else if (a[mid] > a[high]) {
                low = mid + 1; // Move low to mid + 1, as mid cannot be the minimum
            }
            // If duplicates exist, reduce the search space
            else {
                low++; // Decrementing the search range to handle duplicate elements
            }
        }
        return a[low]; // At the end of the loop, low will point to the minimum element
    }
}
