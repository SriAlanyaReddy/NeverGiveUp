import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // first and last elements are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // middle elements are sum of two numbers from previous row
                    int val = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                    row.add(val);
                }
            }
            ans.add(row);
        }

        // return only the desired row
        return ans.get(rowIndex);
    }
}
