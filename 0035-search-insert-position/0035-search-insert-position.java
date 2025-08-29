class Solution {
    public int searchInsert(int[] a, int target) {
        int n=a.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=high+(high-low)/2;
            if(a[mid]==target){
                return mid;
            }
            else if(a[mid]>target){
            high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }
}