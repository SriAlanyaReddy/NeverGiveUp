class Solution {
    public List<List<Integer>> permuteUnique(int[] a) {
        int n=a.length;
        Arrays.sort(a);
        boolean used[]=new boolean[n];
        List<List<Integer>> res=new ArrayList<>();
        List<Integer>current=new ArrayList<>();
        find(a,used,res,current);
        return res;
    }
    public void find(int[] a,boolean[] used,List<List<Integer>>res,List<Integer>current){
        if(current.size()==a.length){
            res.add(new ArrayList<>(current));
            return;
        }
        int n=a.length;
        for(int i=0;i<n;i++){
            if(used[i])continue;
            if(i>0 && a[i-1]==a[i] && used[i-1]=false) continue;
            current.add(a[i]);
            used[i]=true;
            find(a,used,res,current);
            current.remove(current.size()-1);
            used[i]=false;
        }
    }
}