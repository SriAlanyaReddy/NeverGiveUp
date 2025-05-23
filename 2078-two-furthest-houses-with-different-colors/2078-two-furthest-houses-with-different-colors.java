class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        //intuition is to think greedily 
        // we get max distance from first or last 
        //to compare first house with all other houses and compare last house iwth all other e ghouses take max of both
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(colors[0]!=colors[i]){
                max=Math.max(max,i);
            }
            if(colors[n-1]!=colors[i]){
                max=Math.max(max,n-i-1);
            }
        }
        return max;
    }
}