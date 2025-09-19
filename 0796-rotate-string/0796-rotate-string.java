import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        Deque<Character> charDeque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            charDeque.addLast(c);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char firstChar = charDeque.removeFirst();
            charDeque.addLast(firstChar);
            
            // Convert the deque back to a string
            StringBuilder rotatedString = new StringBuilder();
            for (char c : charDeque) {
                rotatedString.append(c);
            }
            
            if (rotatedString.toString().equals(goal)) {
                return true;
            }
        }
        
        return false;
    }
}
