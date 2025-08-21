import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        // collect unique elements
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // sort them (important for correct LeetCode output)
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        // write back to nums[]
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }

        return list.size(); // k = number of unique elements
    }
}
