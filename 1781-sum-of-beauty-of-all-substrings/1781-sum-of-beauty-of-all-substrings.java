class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        // Outer loop chooses starting index of substring
        for (int i = 0; i < n; i++) {

            // Frequency array for 26 lowercase characters
            int[] freq = new int[26];

            // Inner loop chooses ending index of substring
            for (int j = i; j < n; j++) {

                // Update frequency of current character
                freq[s.charAt(j) - 'a']++;

                int maxFreq = Integer.MIN_VALUE;
                int minFreq = Integer.MAX_VALUE;

                // Find max and min frequency among characters present in current substring
                for (int k = 0; k < 26; k++) {
                    maxFreq = Math.max(maxFreq, freq[k]);
                    if (freq[k] != 0) {  // only consider characters that appear
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }

                // Beauty = max frequency − min frequency
                totalBeauty += (maxFreq - minFreq);
            }
        }

        return totalBeauty;
    }
}
