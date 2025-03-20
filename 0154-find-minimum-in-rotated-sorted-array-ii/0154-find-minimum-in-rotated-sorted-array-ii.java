class Solution {
    public int findMin(int[] a) {
        int low=0;
        int high=a.length-1;
        
        //which means array us not rotated
        while(low<high){
            int mid=(high-low)/2+low;
            if(a[low]<a[high]){
            return a[low];
        }
            else if(a[low]>a[mid]){
                high=mid;

            }

            else if(a[mid]>a[high]){
                low=mid+1;
            }
            else{
                low++;
            }


        }
        return a[low];
    }
}