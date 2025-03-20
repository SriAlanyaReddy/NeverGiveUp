class Solution {
    public boolean search(int[] a, int target) {
        int n=a.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(a[mid]==target){
                return true;
            }
            else if(a[mid]==a[low] && a[high]==a[mid]){
                low++;
                high--;
            }
            else if(a[low]<=a[mid]){
                if(a[low]<=target && target<=a[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(target>=a[mid] && target<=a[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }

        }
        return false;
        
    }
}