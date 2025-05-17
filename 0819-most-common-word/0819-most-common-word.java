class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
       String paragraph1[] = paragraph.toLowerCase().replaceAll("[!?',;.]"," ").split(" ");
        HashSet<String>ban=new HashSet<>();
        for(String b:banned){
            ban.add(b);
        }
        HashMap<String,Integer>mp=new HashMap<>();
        for(String word:paragraph1){
            if(!ban.contains(word)){
                mp.put(word,mp.getOrDefault(word,0)+1);
            }
        }
        int max=0;
        String ans="";

        for(String val:mp.keySet()){
            if(mp.get(val)>max){
                max=mp.get(val);
                ans=val;
            }
        }
        return ans;

    }
}