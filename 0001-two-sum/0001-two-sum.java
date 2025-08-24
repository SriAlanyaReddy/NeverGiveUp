class Solution {
    public int[] twoSum(int[] a, int target) {
        int n=a.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int remaining=target-a[i];
            if(map.containsKey(remaining)){
                return new int[]{i,map.get(remaining)};
            }
            mp.put(a[i],i);
        }
        return new int[0];
        
    }
}