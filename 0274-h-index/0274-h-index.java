class Solution {
    public int hIndex(int[] a) {
        int high=a.length,low=0,ans;
        while(low<high)
            int mid=(low+high+1)/2;
            for(int i=0;i<n;i++){
                if(a[i]>=mid){
                    c++;
                }
            }
            if(c>=mid){
               ans=mid;
               low=mid;
            }
            else high=mid-1;
        }
        return ans;
    }
}