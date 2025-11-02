class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        String s="";

        parenthesis(s,n,res,n);
        return res;
    }
    public void parenthesis(String s,int open,List<String>res,int close){
        if(open==0 && close==0){
            res.add(s);
            return;
        }
        if(open>0){
            parenthesis(s+"(",open-1,res,close);
        }
        if(open<close){
            parenthesis(s+")",open,res,close-1);

        }
    }
}