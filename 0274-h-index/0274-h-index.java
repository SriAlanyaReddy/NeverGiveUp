class Solution {
    public int hIndex(int[] a) {
        int n=a.length;
        
        for(int hindex=n;hindex>=0;hindex--){
            int c=0;
            for(int i=0;i<n;i++){
                if(a[i]>=hindex){
                    c++;
                }
            }
            if(c>=hindex){
                return hindex;
            }
        }
        return -1;
    }
}