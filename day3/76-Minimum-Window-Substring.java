class Solution {
    public String minWindow(String s, String t) {
        /***my approach is maintain a map with count of each charcater in t
        then run a loop for s when character in int == charcter in s then since yiu  used that charcter then decrement mapcount if cmapcount**/
      if (s.length() < t.length()) return \\; // Edge case: t is longer than s

        int hash[] = new int[128]; // ASCII character frequency array
        int sl = s.length();
        int tl = t.length();

        for(int i=0;i<tl;i++){
            hash[t.charAt(i)]++;
        }
        int r=0;
        int l=0,minlen=Integer.MAX_VALUE,cnt=0;
        int startindex=-1;
        while(r<sl){
            if(hash[s.charAt(r)]>0){
                cnt++;
            }
            hash[s.charAt(r)]--;
            while(cnt==tl){
                if(r-l+1 <minlen){
                   minlen=r-l+1;
                   startindex=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0){
                    cnt--;
                }
                
                l++;
            }
            r++;

        }
        return startindex==-1?\\:s.substring(startindex,startindex+minlen);
    }
}