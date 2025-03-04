class Solution {
    public int longestConsecutive(int[] a) {
        int count=1;
        int n=a.length;
       Arrays.sort(a);
        int max=1;
        if(n==0) return 0;

        for(int i=1;i<n;i++){
            if(a[i]!=a[i-1]){
            if(a[i]==a[i-1]+1){
                count++;
            }
            else{
                max=Math.max(count,max);
                count=1;
            }
            }

        }
        return Math.max(count,max);
    }
}