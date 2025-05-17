class Solution {
    public int[] intersection(int[] a1, int[] a2) {
        Hashset<Integer>mp=new HashMap<>();
        for(int i:a1){
            mp.add(i);
        }
        List<Integer>a=new ArrayList<>();
        for(int i:a2){
            if(mp.contains(i)){
                a.add(i);
                mp.remove(i);
            }
        }
         // Convert List<Integer> to int[]
        int[] result = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            result[i] = a.get(i);
        }
        
        return result;
    }
}