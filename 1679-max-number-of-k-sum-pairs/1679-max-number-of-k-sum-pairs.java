class Solution {
    public int maxOperations(int[] a, int k) {
        int n=a.length;
        Arrays.sort(a);
        int left=0,right=n-1,op=0;
        while(left<=right){
            int sum=a[left]+a[right];
            if(sum==k){
                op++;
                left++;
                right--;
            }
            else if(sum>k){
                right--;
            }
            else{
                left++;
            }

        }
        return op;
        
    }
}