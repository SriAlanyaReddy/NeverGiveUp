class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int count = 0;
        int n = properties.length;

        // Sort: Descending by attack, Descending by defense (Fix applied)
        Arrays.sort(properties, (a, b) -> 
            (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));

        int maxDefense = Integer.MIN_VALUE;

        // Iterate to find weak characters
        for (int i = n-1; i >=0; i--) {
            if (properties[i][1] < maxDefense) {
                count++; // Weak character found
            }
            maxDefense = Math.max(maxDefense, properties[i][1]); // Track highest defense so far
        }

        return count;
    }
}
