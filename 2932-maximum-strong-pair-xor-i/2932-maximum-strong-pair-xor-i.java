class Solution {
    public int maximumStrongPairXor(int[] a) {
        int n=a.length;
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a1=a[i],a2=a[j];
                if(Math.abs(a1-a2)<=Math.min(a1,a2)){
                    max=Math.max(a1^a2,max);
                }

            }
        }
        return max;
    }
}