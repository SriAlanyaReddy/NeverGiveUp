class Solution {
    public void sortColors(int[] a) {
        //dutch falg algorithm
        int mid=0,low=0,high=a.length-1;
        while(mid<=high){
            if(a[mid]==0){
                int temp=a[low];
                a[low]=a[mid];
                a[mid]=temp;
                low++;
                mid++;
            }
            else if(a[mid]==1){
                mid++;
            }
            else {
                int temp=a[high];
                a[high]=a[mid];
                a[mid]=temp;
                high--;
            }
        }

    }
}