class Solution {
    public long findMaximumScore(List<Integer> a) {
        int n=a.size();
        long ans=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            ans+=(long)maxi;
            maxi=Math.max(maxi,a.get(i));
          
        }
        return ans;
    }
}