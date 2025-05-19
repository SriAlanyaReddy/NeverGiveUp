class Solution {
    public int minimumMoves(String s) {
        int n=s.length(),i=0,c=0;
        while(i<n){
            if(s.charAt(i)=='X'){
                c++;
                i+=3;
            }
            else{
                i++;
            }
        }
        return c;
        
    }
}