class Solution {
    public int secondHighest(String s) {
        boolean[] seen = new boolean[10]; // track which digits appear

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                seen[ch - '0'] = true;
            }
        }

        int count = 0;
        for (int i = 9; i >= 0; i--) {
            if (seen[i]) {
                count++;
                if (count == 2) return i; // second largest
            }
        }

        return -1; // if no second largest
    }
}
