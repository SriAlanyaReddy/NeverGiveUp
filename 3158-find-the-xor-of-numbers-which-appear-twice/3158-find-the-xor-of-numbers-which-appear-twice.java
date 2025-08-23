import java.util.*;

class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int result = 0;

        // Count frequencies
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // XOR numbers appearing exactly twice
        for (int key : freq.keySet()) {
            if (freq.get(key) == 2) {
                result ^= key;
            }
        }

        return result;
    }
}
