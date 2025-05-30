class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();

       int prev[]=new int[m+1];
       prev[0]=1;


        // Fill the table
        for (int i = 1; i <= n; i++) {
            int[] curr=new int[m+1];
            curr[0]=1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Include + Exclude
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    // Exclude only
                    curr[j]= prev[j];
                }
            }
            prev=curr;
        }

        return prev[m];
    }
}
