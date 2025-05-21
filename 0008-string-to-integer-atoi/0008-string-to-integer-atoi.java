class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int isNegative = 1;
        s=s.trim();
        if(s.isEmpty()) return 0;

        // Check for negative sign
        if (s.charAt(i) == '-' || s.charAt(i)=='+') {
            isNegative =s.charAt(i)=='-'?-1:1;
            i++;
        }

        int n = s.length();
        int cnt = 0;

        // Skip leading zeros
        while (i < n && s.charAt(i) == '0') {
            System.out.println("zero encountered");
            cnt++;
            i++;
        }
        

        // If all are zeros
        if (i == n) {
           
            return 0;
        }
       

        int sum = 0;

        // Convert digits to number
        while (i < n && Character.isDigit(s.charAt(i))) {
            int num = s.charAt(i) - '0';
            sum = sum * 10 + num;
            if(sum*isNegative > Integer.MAX_VALUE){
               return Integer.MAX_VALUE;
              
            }
            if(sum*isNegative < Integer.MIN_VALUE){
              return Integer.MIN_VALUE;
               
                
            }
            i++;
        }

        return (int)isNegative * sum;
    }
}
