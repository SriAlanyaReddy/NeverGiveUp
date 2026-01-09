class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         Set<String> wordSet = new HashSet<>(wordList);

        // If endWord is not in the list, no solution
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Queue for BFS: stores current word and level
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Visited set to avoid revisiting words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process one level at a time
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // If endWord found
                if (currentWord.equals(endWord)) {
                    return level;
                }

                char[] wordChars = currentWord.toCharArray();

                // Try changing each character
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        // If valid transformation
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }

                    // Restore original character
                    wordChars[j] = originalChar;
                }
            }

            level++;
        }

        return 0;
    }
}