class Solution {
    public int numRabbits(int[] answers) {
        //our appraoch we absiclyy try to deivide into gropus
        //we will try to findout size of grp
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i:answers){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        int ans=0;
        for(int key:mp.keySet()){
            ans+=(int)Math.ceil((double)mp.get(key)/(key+1))*(key+1);
        }
        return ans;
    }
}