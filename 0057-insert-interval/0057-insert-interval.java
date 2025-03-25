import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        
        // Insert all existing intervals into res first
        for (int[] i : intervals) {
            res.add(new int[]{i[0], i[1]});
        }
        
        // Insert new interval
        res.add(new int[]{newInterval[0], newInterval[1]});
        
        // Sort intervals based on start time
        res.sort(Comparator.comparingInt(a -> a[0]));
        
        // Merge intervals using your approach
        ArrayList<int[]> merged = new ArrayList<>();
        for (int[] i : res) {
            int currentStart = i[0];
            int currentEnd = i[1];
            
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < currentStart) {
                merged.add(new int[]{currentStart, currentEnd});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], currentEnd);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
