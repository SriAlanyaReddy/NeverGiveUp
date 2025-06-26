class Solution {
    public int[] nextGreaterElements(int[] a) {
        int n=a.length;
        int ans[]=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<i+n;j++){
                int ind=j%n;
                if(a[i]<a[ind]){
                    ans[i]=a[ind];
                    break;
                }
            }
        }
        return ans;
        
    }
}