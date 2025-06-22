class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character,Integer>freq=new HashMap<>();
        int min=Integer.MAX_VALUE;

        for(char ch:word.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        for(int a:freq.values()){
            int del=0;
            for(int b:freq.values()){
                if(a>b)
                 del+=val1;
                 else if(b>a+k){
                    del+=b-(a+k);
                 }

            }
            min=Math.min(del,min);
        }
        return min;
    }
}