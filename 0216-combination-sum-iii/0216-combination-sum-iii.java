class Solution {
     public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[10]; // to keep track of numbers from 1 to 9
        find(0, k, 0, used, ans, temp, n);
        return ans;
    }

    private void find(int ind, int k, int sum, boolean[] used, List<List<Integer>> ans, List<Integer> temp, int target) {
        if(temp.size()==k && sum==target){
            ans.add(temp);
            return;
        }
        if(temp.size()>k || sum>target){
            return ;
        }

        for(int i=ind+1;i<10;i++){
            if(!used[i]){
                used[i]=true;
                temp.add(i);
                find(i,k,sum+i,used,ans,temp,target);
                temp.remove(temp.size()-1);
                used[i]=false;
            }
        }
    }
}