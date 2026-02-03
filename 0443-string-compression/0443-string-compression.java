class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < chars.length) {
            char current = chars[i];
            int count = 0;

            // count consecutive characters
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }

            sb.append(current);

            if (count > 1) {
                sb.append(count); // no need for manual digit logic
            }
        }

        // write back to chars (required by problem)
        for (int k = 0; k < sb.length(); k++) {
            chars[k] = sb.charAt(k);
        }

        return sb.length();
    }
}
