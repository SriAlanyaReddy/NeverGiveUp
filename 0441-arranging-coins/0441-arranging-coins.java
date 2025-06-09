class Solution {
    public int arrangeCoins(int n) {
        long low = 0, high = n;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long curr = mid * (mid + 1) / 2;
            
            if (curr == n) return (int) mid;
            if (curr < n) low = mid + 1;
            else high = mid - 1;
        }
        
        return (int) high; // high will be the largest k such that k(k+1)/2 <= n
    }
}
