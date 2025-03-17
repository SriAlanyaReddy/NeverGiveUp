class Solution {
    public boolean divideArray(int[] a) {
        /*my approach is if any element occurs odd number number of times then it is not possible to divide an array into n pairs
        */
        int n=a.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(a[i],map.getOrDefault(a[i],0)+1);
        }
        for(int value:map.values()){
            if(value%2!=0) return false;
        }
        return true;
    }
}