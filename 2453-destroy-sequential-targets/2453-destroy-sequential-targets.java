class Solution {
    public int destroyTargets(int[] a, int space) {
        int n=a.length;
        Arrays.sort(a);
        int maxn=Integer.MIN_VALUE;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            int diff=a[i]%space;
            mp.put(diff,mp.getOrDefault(diff,0)+1);
            if(maxn<mp.get(diff)){
                maxn=mp.get(diff);
            }
            
           

        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(maxn==mp.get(a[i]%space)){
                ans=Math.min(ans,a[i]);
            }
        }
        return ans;
        
    }
}