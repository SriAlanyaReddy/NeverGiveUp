c

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Set<Integer> usedFreq = new HashSet<>();
        int deletions = 0;

        for (int f : freq) {
            while (f > 0 && usedFreq.contains(f)) {
                f--;          // Delete one character
                deletions++;  // Count the deletion
            }
            usedFreq.add(f);
        }

        return deletions;
    }
}
