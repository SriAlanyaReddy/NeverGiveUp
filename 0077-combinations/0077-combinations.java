class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();

        find(ans,1,k,temp,n);
        return ans;
    }
    public void find( List<List<Integer>>ans,int start,int k,List<Integer>temp,int n){
if(temp.size()==k){
    ans.add(new ArrayList<>(temp));
    return;
}
for(int i=start;i<=n;i++){
    temp.add(i);
    find(ans,i+1,k,temp,n);
    temp.remove(temp.size()-1);

}

        
    }
}