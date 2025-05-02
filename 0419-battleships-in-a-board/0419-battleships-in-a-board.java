class Solution {
    public int countBattleships(char[][] a) {
        int c=0;
        int n=a.length;
        int m=a[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]=='.'){
                    continue;
                }
                if(i>0 && a[i-1][j]=='X'){
                    continue;
                }
                if(j>0 && a[i][j-1]=='X'){
                    continue;
                }
                c++;
            }
        }
        return c;
    }
}