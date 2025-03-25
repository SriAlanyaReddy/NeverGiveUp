class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return isValid(rectangles,0) || isValid(rectangles,1);
    }
    public boolean isValid(int[][] rectangles,int axis){
        Arrays.sort(rectangles,Comparator.comparingInt(a->a[axis]));
        int countnonoverlappingintervals=0;
        int prevend=-1;
        for(int rec[]:rectangles){
            int currentstart=rec[axis];
            int currentend=rec[axis+2];

            if(currentstart>=prevend){
                countnonoverlappingintervals++;
            }
            prevend=Math.max(currentend,prevend);
            if(countnonoverlappingintervals>=3){
                return true;
            }
        }
        return false;
    }
}