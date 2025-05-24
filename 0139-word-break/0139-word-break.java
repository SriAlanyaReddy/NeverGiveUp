class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        HashSet<String>map=new HashSet<>();
        int maxlen=Integer.MIN_VALUE;
        for(int i=0;i<wordDict.size();i++){
            map.add(wordDict.get(i));
            maxlen=Math.max(maxlen,wordDict.get(i).length());
        }
        boolean dp[]=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxlen);j--){
                if(dp[j]==true && map.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }

        }
        return dp[n];
    }
}