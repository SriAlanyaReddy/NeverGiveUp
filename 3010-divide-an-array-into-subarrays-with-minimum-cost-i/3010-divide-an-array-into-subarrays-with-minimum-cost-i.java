class Solution {
    public int minimumCost(int[] a) {
        ///here w ehave to find minimum element in list 
        int cost=a[0];
        int min=Integer.MAX_VALUE,secondmin=Integer.MAX_VALUE;
        for(int i=1;i<a.length;i++){
            if(a[i]<min){
               secondmin=min;
               min=a[i];
            }
            else if(a[i]<secondmin){
                secondmin=a[i];
            }
        }
        return min+secondmin+cost;
    }
}