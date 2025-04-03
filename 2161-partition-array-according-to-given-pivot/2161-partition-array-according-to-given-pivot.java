import java.util.*;

class Solution {
    public int[] pivotArray(int[] a, int pivot) {
        int n = a.length;
        ArrayList<Integer> a1 = new ArrayList<>(); // Stores elements < pivot
        ArrayList<Integer> a2 = new ArrayList<>(); // Stores elements == pivot
        ArrayList<Integer> a3 = new ArrayList<>(); // Stores elements > pivot

        // Partition elements into three lists
        for (int num : a) {
            if (num < pivot) {
                a1.add(num);
            } else if (num == pivot) {
                a2.add(num);
            } else {
                a3.add(num);
            }
        }

        // Merge three lists into the result array
        int[] res = new int[n];
        int ind = 0;

        for (int num : a1) res[ind++] = num; // Add elements < pivot
        for (int num : a2) res[ind++] = num; // Add elements == pivot
        for (int num : a3) res[ind++] = num; // Add elements > pivot

        return res;
    }
}
