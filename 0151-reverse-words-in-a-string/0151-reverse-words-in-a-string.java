class Solution {
    public String reverseWords(String s) {
        // remove leading/trailing spaces and split by 1+ spaces
        String[] words = s.trim().split("\\s+");

        int i = 0, j = words.length - 1;
        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }

        return String.join(" ", words);
    }
}
