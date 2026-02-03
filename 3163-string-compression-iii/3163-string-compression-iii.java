class Solution {
    public String compressedString(String word) {
        int i=0,n=word.length();
        StringBuilder sb=new StringBuilder();
        while(i<n){
           char current=word.charAt(i);
           /*if(i+9<word.length() && current==word.charAt(i+9)){
            sb.append(9).append(current);
            i+=9;
           }*/
          
            int c=0;
            while(i<n  && current==word.charAt(i) && c<9 ){
                
                c++;
                i++;
            
            }
            sb.append(c).append(current);
           
        }
        return sb.toString();
        
    }
}