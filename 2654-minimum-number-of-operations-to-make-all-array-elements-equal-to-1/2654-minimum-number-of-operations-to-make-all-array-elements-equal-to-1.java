class Solution {
    public int minOperations(int[] a) {
        int ones = 0;
        int n = a.length;
        
        // First, count how many 1s exist
        for (int n1 : a) {
            if (n1 == 1) {
                ones++;
            }
        }

        // If we already have some 1s, we need (n - ones) operations
        if (ones > 0) {
            return n - ones;
        }

        // Now search for the smallest subarray with GCD 1
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int currGCD = a[i];
            for (int j = i + 1; j < n; j++) {
                currGCD = gcd(currGCD, a[j]);
                if (currGCD == 1) {
                    res = Math.min(res, j - i);
                    break; // no need to go further if GCD is already 1
                }
            }
        }

        if (res == Integer.MAX_VALUE) {
            return -1;
        }

        // It takes res operations to create one 1,
        // and then (n - 1) operations to convert others using that 1
        return res + n - 1;
    }

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
