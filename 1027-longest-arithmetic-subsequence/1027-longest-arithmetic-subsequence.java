class Solution {
    public int longestArithSeqLength(int[] a) {
        int n=a.length;
        int maxlen=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int len=2;
                int diff=a[j]-a[i];
                int prev=a[j];
                for(int k=j+1;k<n;k++){
                    if(a[k]-prev==diff){
                        len++;
                        prev=a[k];
                    }
                }
                maxlen=Math.max(len,maxlen);
            }
        }
        return maxlen;
    }
}