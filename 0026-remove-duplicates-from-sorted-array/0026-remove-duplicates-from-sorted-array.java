import java.util.*;

class Solution {
    public int removeDuplicates(int[] a) {
        // collect unique elements
       // k = number of unique elements
       int n=a.length;
       int i=0;
       for(int j=1;j<n;j++){
        if(a[i]!=a[j]){
            i++;
            a[i]=a[j];
        }

       }
       return i+1;
    }
}
/*
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

        return list.size(); */