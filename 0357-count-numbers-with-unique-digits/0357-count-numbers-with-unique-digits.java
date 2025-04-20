class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        boolean[] used = new boolean[10]; // to track used digits
        return backtrack(0, n, used, false);
    }

    // idx → current digit position, n → max number of digits, used → digits used so far
    // isNumStarted → flag to check if number has started (to allow leading 0 or not)
    private int backtrack(int idx, int n, boolean[] used, boolean isNumStarted) {
        if (idx == n) {
            return isNumStarted ? 1 : 0; // count only if we've actually started a number
        }

        int count = 0;

        // At each digit position, try placing digits 0-9
        for (int d = 0; d <= 9; d++) {
            if (!isNumStarted && d == 0) {
                // Allow leading zero (i.e., starting with 0), but don't mark it used
                count += backtrack(idx + 1, n, used, false);
            } else if (!used[d]) {
                // Choose digit d
                used[d] = true;
                count += backtrack(idx + 1, n, used, true);
                used[d] = false; // backtrack
            }
        }

        // Also allow the option to stop early (not using all n digits) — only if number started
        if (isNumStarted) {
            count += 1; // count current formed number (even if < n digits)
        }

        return count;
    }
}
