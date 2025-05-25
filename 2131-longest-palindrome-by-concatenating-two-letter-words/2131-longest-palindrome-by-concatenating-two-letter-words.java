class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer>map=new HashMap<>();
        int res=0;
        int n=words.length;
        for(int i=0;i<n;i++){
            String w1=words[i];
            String reversed=new StringBuilder(w1).reverse().toString();
           
            if(map.getOrDefault(reversed,0)>0){
                res+=4;
                map.put(reversed,map.get(reversed)-1);
            }
            else{
                map.put(w1,map.getOrDefault(w1,0)+1);
            }

        }
        boolean hascenter=false;
        for(String s:map.keySet()){
            if(s.charAt(0)==s.charAt(1) && map.get(s)>0 ){
                hascenter=true;
                break;
            }
        }
        return (hascenter)?res+2:res;
    }
}