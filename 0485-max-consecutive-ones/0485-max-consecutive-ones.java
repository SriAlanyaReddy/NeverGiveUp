class Solution {
    public int findMaxConsecutiveOnes(int[] a) {
        int n=a.length;
        int max=0,c=0;
        for(int i=0;i<n;i++){
            if(a[i]==1){
                c++;

            }
            else{
                max=Math.max(c,max);
                c=0;
            }
        }
        return   Math.max(max, c); 
        
    }
}