class Solution {
    public int smallestDivisor(int[] a, int threshold) {
        int left = 1;
        int right = 0;
        
        for (int x : a)
            right = Math.max(right, x);

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(a, mid, threshold)) {
                ans = mid;
                right = mid - 1;   // try smaller divisor
            } else {
                left = mid + 1;    // need bigger divisor
            }
        }
        return ans;
    }

    private boolean isPossible(int[] a, int val, int limit) {
        int sum = 0;
        for (int x : a) {
            sum += (x + val - 1) / val;   // ceil(x / val)
            if (sum > limit) return false;
        }
        return true;
    }
}
