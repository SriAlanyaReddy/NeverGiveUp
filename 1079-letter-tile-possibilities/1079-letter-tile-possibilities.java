import java.util.*;

class Solution {
    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr); // Sort to handle duplicates
        return backtrack(arr, used);
    }

    private int backtrack(char[] tiles, boolean[] used) {
        int count = 0;

        for (int i = 0; i < tiles.length; i++) {
            if (used[i] || (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1])) {
                continue; // Skip duplicate choices
            }
            used[i] = true;
            count += 1 + backtrack(tiles, used); // Count current sequence + further possibilities
            used[i] = false;
        }

        return count;
    }
}
