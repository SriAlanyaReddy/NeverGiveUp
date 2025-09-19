class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String>ans=new ArrayList<>();
        for(String word:words){
            HashMap<Character,Character>mp1=new HashMap<>();
            HashMap<Character,Character>mp2=new HashMap<>();
            int n=pattern.length();
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(mp1.containsKey(pattern.charAt(i))){
                    if(mp1.get(pattern.charAt(i))!=word.charAt(i)){
                        flag=false;
                        break;
                    }
                }
                if(mp2.containsKey(word.charAt(i))){
                    if(mp2.get(word.charAt(i))!=pattern.charAt(i)){
                        flag=false;
                        break;
                    }
                }
                mp1.put(pattern.charAt(i),word.charAt(i));
                mp2.put(word.charAt(i),pattern.charAt(i));


            }
            if(flag)ans.add(word);
        }
        return ans;
    }
}