class Solution {
    public int longestPalindrome(String s) {
        // Set to store characters that appear an odd number of times
        HashSet<Character> map = new HashSet<>();
        int res = 0;

        // Loop through each character in the string
        for (char ch : s.toCharArray()) {
            // If this is the first time we see the character, add to set
            if (!map.contains(ch)) {
                map.add(ch);
            } else {
                // If we see it again (second time), we can form a pair
                res += 2; // add 2 to the result (pair formed)
                map.remove(ch); // remove the character from the set
            }
        }

        // If any characters are left in the set,
        // that means one of them can be used as the center of the palindrome
        if (!map.isEmpty()) {
            res += 1;
        }

        // Return the total length of the longest palindrome
        return res;
    }
}
