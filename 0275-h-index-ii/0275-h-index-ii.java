class Solution {
   
    public int hIndex(int[] a) {
        int n = a.length;
        int low = 0, high = n, ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int c = 0;

            // Count how many papers have citations >= mid
            for (int i = 0; i < n; i++) {
                if (a[i] >= mid) {
                    c++;
                }
            }

            if (c >= mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
 
