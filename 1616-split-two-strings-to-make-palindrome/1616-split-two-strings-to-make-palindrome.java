class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
       /* for (int i = 0; i < a.length(); i++) {
            // cut at index 'i'
            String ap = a.substring(0, i);  // a-prefix
            String as = a.substring(i);     // a-suffix
            String bp = b.substring(0, i);  // b-prefix
            String bs = b.substring(i);     // b-suffix

            StringBuilder sb = new StringBuilder();
            // concatenate a-prefix and b-suffix
            sb.append(ap).append(bs);   
            // check if its a palindrome
            if (isPalindrome(sb.toString())) {
                return true;
            }
            // empty the stringbuilder
            sb.setLength(0);    
            // concatenate b-prefix and a-suffix
            sb.append(bp).append(as);
            // check if its a palindrome
            if (isPalindrome(sb.toString())) {
                return true;
            }
        }

        return false;
    }

    // method to check if a string is palindrome or not
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }*/
    //here our goal is to find longets prefix
    /*The idea is to iterate from:

The start of a (a-prefix) and the end of b (b-suffix),
The start of b (b-prefix) and the end of a (a-suffix)
and check for how long we get the same letter.

To the extent we get the same letters, the concatenation would be a palindrome.

If we have same letters from both ends till mid point, we have a desired split already.

"xy" + "yx" = palindrome

If there are letters left in between, we need to check if they make a palindrome or not.

"xy" + palindrome + "yx" = palindrome

"xy" + (not palindrome) + "yx" = not palindrome*/
return cut(a,b)|| cut(b,a);
    }
 // method to match letters from both ends
    private boolean cut(String a, String b) {
        int i = 0, j = a.length() - 1;
        // converge from both ends till we have same letters
        while(i<j && a.charAt(i)==b.charAt(j)){
            i++;j--;
        }
        if(i>=j) return true;
        return isPalindrome(a,i,j) || isPalindrome(b,i,j);

    }
    private boolean isPalindrome(String s,int i,int j) {
       
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}