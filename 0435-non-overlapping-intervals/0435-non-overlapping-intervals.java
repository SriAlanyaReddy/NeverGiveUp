class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,Comparator.comparingint(a->a[1]));
        int c=1;
        int lastendtime=intervals[0][1];
        for(int i=1;i<n;i++){
           int start=intervals[i][0];
           int end=intervals[i][1];
           if(lastendtime<=start){
            c++;
            lastendtime=Math.max(intervals[i][1],lastendtime);

           }
            
        }
        return n-c;
    }
}