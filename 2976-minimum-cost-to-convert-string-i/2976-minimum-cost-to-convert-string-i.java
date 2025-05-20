class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
    long[][] adj=new long[26][26];
        int max=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            Arrays.fill(adj[i],max);
        }
        int n1=original.length;
        for(int i=0;i<n1;i++){
            int strt=original[i]-'a';
            int end=changed[i]-'a';
            adj[strt][end]=Math.min(adj[strt][end],(long)cost[i]);
        }
    for(int k=0;k<26;k++){
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
              
            adj[i][j]=Math.min(adj[i][j],adj[i][k]+adj[k][j]);
            }
        }
    }
    int totalcost=0;
    for(int i=0;i<source.length();i++){
        if(source.charAt(i)==target.charAt(i)){
            continue;
        }
        int strt=source.charAt(i)-'a',targetchar=target.charAt(i)-'a';
        if(adj[strt][targetchar]>=max){
            return -1;
        }
        totalcost+=adj[strt][targetchar];
    }
    return totalcost;
    }
}