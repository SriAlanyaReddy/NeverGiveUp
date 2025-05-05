class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int profit=Integer.MIN_VALUE;
        for(int i:prices){
            if(i<min){
                min=i;
               
            }
             profit=Math.max(i-min,profit);
        }
        return profit;

    }
}