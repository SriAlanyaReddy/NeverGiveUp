class Solution {
    public int removeDuplicates(int[] a) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:a){
            set.add(i);
        }
        return set.size();
    }
}