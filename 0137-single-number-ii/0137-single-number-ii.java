class Solution {
    public int singleNumber(int[] a) {
        Arrays.sort(a);
        int n=a.length;
        for(int i=1;i<n;i+=3){
            if(a[i]!=a[i-1]){
                return a[i-1];

            }
        }
        return a[n-1];
        
    }
}