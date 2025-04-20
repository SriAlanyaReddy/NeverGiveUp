class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // If n == 0, the only number is 0
        if (n == 0) return 1;

        
        int total = 10; // Start with base case: n = 1 → 10 digits: 0 to 9
        int uniqueDigits = 9; // For the first digit (1-9), 9 options
        int available = 9; // Remaining digits (excluding the one used for first digit)

        // For each digit length from 2 to n
        for (int i = 2; i <= n; i++) {
            uniqueDigits *= available; // Multiply by available digits for current position
            total += uniqueDigits;     // Add to total
            available--;               // One fewer digit available for next position
        }

        return total;
    }
}
