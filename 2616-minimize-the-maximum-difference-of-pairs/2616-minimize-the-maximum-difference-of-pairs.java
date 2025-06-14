class Solution {
    public int minimizeMax(int[] a, int p) {
        //binary search min diff could be 0,max difference could be max(a[i])
        Arrays.sort(a);
        int n=a.length;
        int low=0,high=a[n-1];
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,a,p)){
                ans=mid;
                //go to smaaler range
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int sum,int[] a,int reqpairs){
        int c=0,i=1,n=a.length;
        while(i<n){
            if(a[i]-a[i-1]<=sum){
                c++;
                i+=2;
            }
            else{
                i++;

            }
            

        }
        return c>=reqpairs;

    }
}