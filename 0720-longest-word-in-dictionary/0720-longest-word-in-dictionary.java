
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null) node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEndOfWord = true; // Mark the end of the word
    }

    // Check if a prefix exists as a valid word in the Trie
    public boolean isValidPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length() - 1; i++) { // Exclude the last character
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null || !node.children[index].isEndOfWord) {
                return false; // If any prefix is not valid, return false
            }
            node = node.children[index];
        }
        return true;
    }
}

class TrieNode {
    boolean isEndOfWord = false;
    TrieNode[] children = new TrieNode[26]; // Each node has 26 children (for 'a' to 'z')
}

class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();

        // Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }

        String longestWord = "";

        // Iterate through words to find the longest valid word
        for (String word : words) {
            // Check if the word can be built (all prefixes except the last one must be valid)
            if (trie.isValidPrefix(word)) {
                // Update the longest word (lexicographically smallest in case of tie)
                if (word.length() > longestWord.length() || 
                    (word.length() == longestWord.length() && word.compareTo(longestWord) < 0)) {
                    longestWord = word;
                }
            }
        }

        return longestWord;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String[] words1 = {"w", "wo", "wor", "worl", "world"};
        System.out.println(solution.longestWord(words1)); // Output: "world"

        // Test case 2
        String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(solution.longestWord(words2)); // Output: "apple"
    }
}
