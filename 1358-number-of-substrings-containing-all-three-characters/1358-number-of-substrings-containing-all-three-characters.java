import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s) {
      int k=3;
      int n=s.length();
      int lastseen[]={-1,-1,-1};
      int cnt=0;
      int r=0;
      while(r<n){
          lastseen[s.charAt(r)-'a']=r;
          if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
            cnt=cnt+Math.min(Math.min(lastseen[0],lastseen[1]),lastseen[2])+1;
          }
          r++;
      }
      return cnt;

    }
    public int findcount(String s,int k){
        int r=0,l=0;
        int n=s.length();
         // We are looking for substrings with exactly 3 distinct characters
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        //my approach is store count of each echarcter in hashmap in when hashmap size is greater than 3 then
        while(r<n){
              map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
              

              while(map.size()>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
              }
              count+=r-l+1;
        }
        return count;

    }
}
