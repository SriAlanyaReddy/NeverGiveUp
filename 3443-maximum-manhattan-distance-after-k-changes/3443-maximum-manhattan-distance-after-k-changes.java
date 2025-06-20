class Solution {
    public int maxDistance(String s, int k) {
        int north=0,south=0,east=0,west=0,ans=0;
        for(char ch:s.toCharArray()){
            switch(ch){
                case 'N':
                north++;
                break;
                case 'S':
                south++;
                break;
                case 'E':
                east++;
                break;
                case 'W':
                west++;
                break;
            }
            int times1=Math.min(Math.min(north,south),k);
            int times2=Math.min(Math.min(east,west),k-times1);
            ans=Math.max(ans,count(north,south,times1)+count(east,west,times2));
        }
        return ans;
        
    }
    private int count(int dirt,int drt2,int k){
        return Math.abs(drt1-drt2)+k*2;
    }
}