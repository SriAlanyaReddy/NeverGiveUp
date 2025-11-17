class Solution {
    public int numSub(String s) {
         int MOD = (int)1_000_000_007;
        int st=0,res=0;
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                st++;
                res=(res+st)%MOD;
               
            }
            else{
                st=0;
            }

        }
        return res;
    }
}