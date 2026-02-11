class Solution {
    static final long mod=1000000007L;
    public int numSub(String s) {
        long ans=0,cur=0;
        for (int i=0;i <s.length(); i++) {
            if (s.charAt(i)=='1'){
                cur++;
                ans=(ans+cur)%mod;

            }else{
                cur=0;
            }
        }
      return (int)ans;  
    }
}
