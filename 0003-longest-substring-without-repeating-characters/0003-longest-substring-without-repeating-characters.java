class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
      int l=0;
      int r=0;
      HashSet<Character>set=new HashSet<>();
      //my appraoch is expand l
      //shrik r
      //my appraoch is it set doentot contain character then append it 
      //if it contains shirk r
    int n=s.length();
      int max=Integer.MIN_VALUE;
     
      while(r<n){
        while(!set.contains(s.charAt(r))){
           set.remove(s.charAt(l));
            l++;    
           

        }
          set.add(s.charAt(r));
        max=Math.max(r-l+1,max);
           r++;
        
            
       
      

      }
      return max;
}}