class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> mp = new HashMap<>();
        
        // Count frequency of words from words1
        for (String word : words1) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        int c = 0;
        for (String word : words2) {
            // Fix: check if word exists AND frequency is 1
            if (mp.get(word) != null && mp.get(word) == 1) {
                c++;
                mp.put(word, 0); // Avoid counting duplicates from words2
            }
        }

        return c;
    }
}
