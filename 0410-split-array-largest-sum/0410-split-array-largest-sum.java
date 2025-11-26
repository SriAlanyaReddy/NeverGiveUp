class Solution {
    public int splitArray(int[] a, int k) {
        
        int right=0;
        int left=Integer.MIN_VALUE;
        for(int i:a){
            right+=i;
            left=Math.max(left,i);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isPossible(a,mid,k)){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    public boolean isPossible(int[] a,int val,int k){
        int countsubarray=1;
        int sum=0;
        for(int i:a){
            sum+=i;
            if(sum>val){
                count++;
                sum=i;
                if(count>k) return false;
            }
        }

      return true;
    }
}