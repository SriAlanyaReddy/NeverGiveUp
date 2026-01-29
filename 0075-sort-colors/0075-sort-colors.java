class Solution {
    public void sortColors(int[]a) {
        int low=0,high=a.length-1,mid=0;

        while(mid<=high){
            if(a[mid]==0){
                int temp=a[mid];
                a[mid]=a[low];
                a[low]=temp;
                low+=1;
                mid+=1;

            }
            else if(a[mid]==1){
                mid++;
            }
            else{
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;

            }
        }
        
    }
}