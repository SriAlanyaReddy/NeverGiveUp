class Solution {
    public int removeElement(int[] a, int val) {
        int n=a.length,i=0;
        for(int j=0;j<n;j++){
            if(a[j]!=val){
                a[i]=a[j];
                i++;
                
                
            }


        }
        return i;
        
    }
}