class Solution {
    public int singleNumber(int[] a) {
        int xor=0;
        for(int i:a){
            xor=xor^i;
        }
        return xor;
        
    }
}