class Solution {
    public String largestOddNumber(String s) {
        //we will try to check largest odd number from last;
        int r=s.length()-1;
        while(r>=0){
            int n=s.charAt(r)-'0';
            if(n%2!=0){
                break;
            }
            r--;
        }
        return s.substring(0,r+1);
    }
}