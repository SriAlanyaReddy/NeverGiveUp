class Solution {
    public int longestPalindrome(String s) {
       HashSet<Character>map=new HashSet<>();
       int n=s.length();
       int res=0;
       for(char ch:s.toCharArray()){
        if(!map.contains(ch)){
            map.add(ch);
        }
        else{
            res+=2;
            map.remove(ch);
        }
       }
       if(!map.isEmpty()) return res+1;
       return res;
       
    }
}