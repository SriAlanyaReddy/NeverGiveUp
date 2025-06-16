class Solution {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            int partindex=s.indexOf(part);
         s=s.substring(0,partindex)+s.substring(partindex+part.length());
        }
        return s;
    }
}