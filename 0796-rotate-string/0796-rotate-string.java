class Solution {
    public boolean rotateString(String s, String goal) {
         Deque<Character> charDeque = new ArrayDeque<>();
          if (s.length() != goal.length()) {
            return false;
        }
        for(char ch:s.toCharArray()){
            charDeque.addLast(ch);
        }
        for(char ch:s.toCharArray()){
            char ch1=charDeque.removeLast();
            charDeque.addFirst(ch1);
            String rot="";
            for(char ch2:charDeque){
                rot=rot+ch2;
            }
            if(rot.equals(goal)){
                return true;
            }
        }
        return false;
    }
}