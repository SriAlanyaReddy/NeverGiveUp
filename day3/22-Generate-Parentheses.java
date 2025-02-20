class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        String s=\\;

        parenthesis(n,s,0,res,0);
        return res;
    }
    public void parenthesis(int n,String s,int open,List<String>res,int close){
        if(open==n && close==n){
            res.add(s);
            return;
        }
        if(open<n){
            parenthesis(n,s+\(\,open+1,res,close);
        }
        if(open>close){
            parenthesis(n,s+\)\,open,res,close+1);

        }
    }
}