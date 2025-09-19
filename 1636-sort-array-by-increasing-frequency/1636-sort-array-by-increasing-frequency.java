import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        // Step 1: Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // Step 2: Max-heap (frequency DESC, number ASC for tie)
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
            new PriorityQueue<>((e1, e2) -> {
                if (!e1.getValue().equals(e2.getValue())) {
                    return e1.getValue() - e2.getValue(); // higher frequency first
                } else {
                    return e1.getKey() - e2.getKey();     // smaller number first
                }
            });

        maxHeap.addAll(freq.entrySet());

        // Step 3: Build result
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            int num = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                nums[idx++] = num;
            }
        }

        return nums;
    }
}
