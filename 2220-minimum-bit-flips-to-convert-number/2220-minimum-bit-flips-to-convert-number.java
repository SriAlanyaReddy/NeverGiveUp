class Solution {
    public int minBitFlips(int start, int goal) {
        

        int n=start^goal;//changeinbits
        int c=0;
        while(n&1){
            c+=n&1;
            n=n>>1;
        }
        return c;

    }
}