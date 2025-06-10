class Solution {
    public boolean isBalanced(String n) {
        int esum=0,osum=0;
        for(int i=0;i<n.length();i++){
            int temp=n.charAt(i)-'0';
          
            if(i%2==0){
                esum+=temp;
            }
            else{
                osum+=temp;

            }
           
            
        }
        return esum==osum;
    }
}