class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long countzero=0;
        long countsubarray=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                countzero++;
                countsubarray+=countzero;
            }
            else{
                countzero=0;
            }
        }
        return countsubarray;
    }
}