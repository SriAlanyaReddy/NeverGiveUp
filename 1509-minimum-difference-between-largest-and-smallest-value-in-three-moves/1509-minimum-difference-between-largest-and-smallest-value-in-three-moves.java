class Solution {
    public int minDifference(int[] a) {
         int n=a.length,mindiff=Integer.MAX_VALUE;
        if (n <= 4) return 0;
       
        Arrays.sort(a);
        for(int left=0,right=a.length-4;left<4;left++,right++){
            mindiff=Math.min(mindiff,a[right]-a[left]);
        }
        return mindiff;

        
    }
}