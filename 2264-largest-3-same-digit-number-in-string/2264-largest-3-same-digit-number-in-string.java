class Solution {
    public String largestGoodInteger(String s) {
        int n = s.length();
        int max = -1; // Use -1 as the initial max, since all good integers are >= 0.

        for (int i = 0; i <= n - 3; i++) {
            // Check if all three characters in the window are the same
            if (s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2)) {
                // Get the numeric value of the character (e.g., '7' -> 7)
                int currentDigit = s.charAt(i) - '0';
                if (currentDigit > max) {
                    max = currentDigit;
                }
            }
        }

        // If no good integer was found, max will still be -1
        if (max == -1) {
            return "";
        }
        
        // Build the result string, e.g., if max is 9, return "999"
        return String.valueOf(max) + String.valueOf(max) + String.valueOf(max);
    }
}