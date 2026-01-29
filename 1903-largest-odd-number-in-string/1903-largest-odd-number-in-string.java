class Solution {
    public String largestOddNumber(String s) {
        int lastindex=s.length()-1;
        while(lastindex>=0){
            if((s.charAt(lastindex)-'0')%2!=0){
                return s.substring(0,lastindex+1);

            }
            lastindex--;
        }
        return "";
    }
}