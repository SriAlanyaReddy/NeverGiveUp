class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] a) {
        Arrays.sort(a);
        int n=a.length;
        int mindiff=Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            mindiff=Math.min(Math.abs(a[i]-a[i+1]),mindiff);

        }
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            int diff=Math.abs(a[i]-a[i+1]);
            if(mindiff==diff){
                l.add(Arrays.asList(a[i],a[i+1]));
            }
        }
        return l;
    }
}