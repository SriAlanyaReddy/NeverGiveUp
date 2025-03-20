class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        //the number is product of minimum column value & row value
        int minrow=m;
        int mincol=n;
        for(int[] o:ops){
            minrow=Math.min(o[0],minrow);
            mincol=Math.min(o[1],mincol);
        }
        return minrow*mincol;
    }
}