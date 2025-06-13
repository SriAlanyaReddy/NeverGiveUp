class Solution {
    public int minimumCost(int[] cost) {
        
        int n=cost.length;
        int i=n-1;
        Arrays.sort(cost);
       
        int sum=0;
        while(i>=0){
            sum=sum+cost[i];
            if(i-1>=0)
            sum+=cost[i-1];
            i=i-3;

        }
        return sum;
        
    }
}