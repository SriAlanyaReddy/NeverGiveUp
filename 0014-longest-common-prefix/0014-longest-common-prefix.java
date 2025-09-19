class Solution {
    public String longestCommonPrefix(String[] words) {
        String smallsubstring="";
        int min=Integer.MAX_VALUE;
        for(String word:words){
            if(word.length()<min){
                min=word.length();
                smallsubstring=word;

            }

        }
        int ind=0;
        while(ind<min){
            for(String word:words){
                if(!word.startsWith(smallsubstring.substring(0,ind+1)){
                  
                    return smallsubstring.substring(0,ind);
                }
            }
            ind++;
        }
        return smallsubstring;
        
    }
}