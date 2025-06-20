class Solution {
    public int findLHS(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        int l=0,r=1,res=0;
        while(r<n){
            int diff=a[r]-a[l];
            if(diff==1) res=Math.max(r-l+1,res);
            if(diff<=1) r++;
            else l++;
        }
        return res;


        
    }
}