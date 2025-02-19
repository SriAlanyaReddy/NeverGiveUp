class Solution {
    public int subarraySum(int[] a, int k) {
        int cnt=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=a.length;
        map.put(0,1);
        int prefixsum=0;
        for(int i=0;i<n;i++){
            prefixsum+=a[i];
            int removesum=prefixsum-k;
            cnt+=map.getOrDefault(removesum,0);
            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return cnt;
    }
}