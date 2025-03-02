class Solution {
    public int[] constructRectangle(int area) {
        int minsum=Integer.MAX_VALUE;
       
        int a[]={-1,-1};
        for(int len=1;len<=area;len++){
            if(area%len==0){
                int ourlength=area/len;
                int ourbreadth=area/ourlength;
                int sum=ourlength+ourbreadth;
                if(sum<minsum && ourlength>=ourbreadth){
                    minsum=sum;
                    a[0]=ourlength;
                    a[1]=ourbreadth;

                }

            }
        }
        return a;
        
    }
}