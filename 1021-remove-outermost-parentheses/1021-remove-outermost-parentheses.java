class Solution {
    public String removeOuterParentheses(String s) {
        int c=0;
        String res="";
        for(char ch:s.toCharArray()){
            if(ch='('){
                if(c!=0){
                    res=res+'(';
                }
                c++;
            }
            else{
                c--;
                if(c!=0){
                    res=res+')';
                }
            }

        }
        return res;
    }
}