
import java.util.*;

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));

        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLength = 1, lastIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[j], words[i]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Print the actual longest chain
        //List<String> chain = new ArrayList<>();
        //while (lastIndex != -1) {
           // chain.add(words[lastIndex]);
            //lastIndex = prev[lastIndex];
        //}
        //Collections.reverse(chain);
        //System.out.println("Longest Word Chain: " + chain);

        return maxLength;
    }

    private boolean isPredecessor(String shorter, String longer) {
        if (longer.length() != shorter.length() + 1) return false;

        int i = 0, j = 0;
        boolean skipped = false;

        while (i < shorter.length() && j < longer.length()) {
            if (shorter.charAt(i) == longer.charAt(j)) {
                i++;
                j++;
            } else if (!skipped) {
                skipped = true;
                j++;
            } else {
                return false;
            }
        }

        return true;
    }
}
