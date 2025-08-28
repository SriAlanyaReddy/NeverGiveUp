class Solution {
    public int numSubarraysWithSum(int[] a, int goal) {
        //to count number of subarryas we can use
        //count subarrays atmost k -count csubarrays atmoct k-1
        return count(a,goal)-count(a,goal-1);
        
        
    }
    public int count(int []a,int goal){
         if (goal < 0) return 0; 
        int r=0;
        int l=0;
        int sum=0;
        int n=a.length;
        int cnt=0;
        while(r<n){
            sum=sum+a[r];
            while(sum>goal){
                
                    sum=sum-a[l];
                
                l++;
            }


            if(sum<=goal){
                cnt=cnt+(r-l+1);
            }
            r++;
        }
        return cnt;
    }
}