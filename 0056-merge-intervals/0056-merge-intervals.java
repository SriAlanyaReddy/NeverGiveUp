class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        int prevend=-1;
        ArrayList<int[]>res=new ArrayList<>();

        for(int[] i:intervals){
            int currentstart=i[0];
            int currentend=i[1];
            if(res.isEmpty() || res.get(res.size()-1)[1]<currentstart){
                res.add(new int[]{currentstart,currentend});

            }
           else{
            res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],currentend);
           }
        }
        return res.toArray(new int[res.size()][]);
        
    }
}