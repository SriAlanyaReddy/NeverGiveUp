class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb=new StringBuilder();
        String s=buildstring(n);
        return s.charAt(k-1);
    }
    public String buildstring(int n){
        if(n==1) return "0";
        String prev=buildstring(n-1);
        return prev+"1"+reverse(invert(prev));
    }
    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    public String invert(String s){
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            sb.append(ch=='0'?'1':'0');
        }
        return sb.toString();
    }
}