class Solution {
    public boolean CanRepairAllIngiventime(int[] ranks,int cars,long time){
        long carsdone=0;
        for(int i=0;i<ranks.length;i++){
            carsdone+=Math.sqrt(time/ranks[i]);
            
            if(carsdone>=cars) return true;
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        int mintime=1;
        long low=1;
        int n=ranks.length;
        long minrank=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minrank=Math.min(ranks[i],minrank);
        }
        long high=minrank*cars*cars;
        while(low<=high){
            long mid=(high-low)/2+low;
            if(CanRepairAllIngiventime(ranks,cars,mid)){
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return low;
        
    }
}