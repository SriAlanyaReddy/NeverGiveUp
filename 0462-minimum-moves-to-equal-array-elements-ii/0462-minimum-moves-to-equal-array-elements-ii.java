class Solution {
    public int minMoves2(int[] nums) {
        int x=1;
        Arrays.sort(nums);
       int  c=0;
        int median=nums[nums.length/2];
        for(int i:nums){
            if(i%x!=median%x){
                return 0;

            }
            c+=Math.abs(i-median)/x;
        }
        return c;
    }
}