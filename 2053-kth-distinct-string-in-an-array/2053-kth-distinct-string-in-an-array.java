class Solution {
    public String kthDistinct(String[] a, int k) {
        Map<String,Integer>mp=new LinkedHashMap<>();
        for(String word:a){
            mp.put(word,mp.getOrDefault(word,0)+1);
        }
        int c=0;
        for(String i:mp.keySet()){
            if(mp.get(i)==1){
                c++;
                if(c==k){
                    return i;
                }
            }
        }
        return "";
        
    }
}