class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int small = Integer.MAX_VALUE;
        for (String s : strs) {
            small = Math.min(s.length(), small);
        }

        for (int i = 0; i < small; i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0].substring(0, small);
    }
}
