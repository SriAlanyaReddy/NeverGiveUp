class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer>mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int mineven=Integer.MAX_VALUE,maxodd=Integer.MIN_VALUE,maxdiff=0;
        for(char ch:mp.keySet()){
            if(mp.get(ch)%2==0){
                mineven=Math.min(mp.get(ch),mineven);
            }
            else{
                maxodd=Math.max(mp.get(ch),maxodd);
            }
           // maxdiff=Math.max(maxodd-maxeven,maxdiff);
        }
        return maxodd-mineven;
        
    }
}