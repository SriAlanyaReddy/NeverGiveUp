class Solution {
    public int maxPower(String s) {
        int max=1,c=1;
        char prev='#';

        for(char ch:s.toCharArray()){
            if(ch!=prev){
                
                max=Math.max(c,max);
                c=1;
                prev=ch;
            }
            else{
                c++;

            }

        }
        return Math.max(c,max);
    }
}