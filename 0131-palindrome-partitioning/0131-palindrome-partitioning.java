class Solution {
    public List<List<String>> partition(String s) {
        List<String>temp=new ArrayList<>();
        List<List<String>>ans=new ArrayList<>();
        findcomb(ans,temp,0,s);
        return ans;
    }
    public void findcomb( List<List<String>>ans,List<String>temp,int start,String s){
        int n=s.length();
        if(start==s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int end=start;end<n;end++){
            if(isPalindrome(s,start,end)){
                temp.add(s.substring(start,end+1));
                findcomb(ans,temp,end+1,s);
                temp.remove(temp.size()-1);

            }
        }
    }
    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;

        }
        return true;
    }
}