class Solution {
    public int minZeroArray(int[] a, int[][] query) {
        int n=a.length;
        int diff[]=new int[n+1];
        int pos=0;
        int sum=0;
        for(int i=0;i<n;i++){
            while(sum+diff[i]<a[i]){
                if(pos==query.length){
                    return -1;
                }
                int start=query[pos][0];
                int end=query[pos][1];
                int val=query[pos][2];
                pos++;
                if(end<i) continue;
                diff[Math.max(start,i)]+=val;
                diff[end+1]-=val;
            }
            sum+=diff[i];
        }
        return pos;
    }
}