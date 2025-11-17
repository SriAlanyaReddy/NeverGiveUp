class Solution {
    public int countHomogenous(String s) {
        char prev='#';
         int MOD = 1_000_000_007;
        long st=0,res=0;
        for(char ch:s.toCharArray()){
            if(prev==ch){
                st++;
            }
            else{
                st=1;
                prev=ch;
            }
            res=(res+st)%MOD;
        }
        return (int)res;
    
    }
}