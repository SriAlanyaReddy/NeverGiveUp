class Solution {
    public int minCut(String s) {
        int n=s.length();
        int[] dp=new int[n];
      
            Arrays.fill(dp,-1);
    
        return find(0,dp,s)-1;
        
    }
    public int find(int ind,int[]dp,String s){
        int n=s.length();
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int min=Integer.MAX_VALUE;
        String temp="";
        
        for(int j=ind;j<n;j++){
            temp=temp+s.charAt(j);
            if(isPalindrome(temp)){
                int cost=1+find(j+1,dp,s);
                min=Math.min(cost,min);
            }
        }
        return dp[ind]=min;
        
    }
    public boolean isPalindrome(String temp){
        int start=0,end=temp.length()-1;
        while(start<=end){
            if(temp.charAt(start)!=temp.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}