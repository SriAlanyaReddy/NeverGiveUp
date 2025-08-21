class Solution {
    public int secondHighest(String s) {
        int n=s.length(),secondlargest=-1,largest=-1;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
             if (Character.isDigit(ch)){
                int val=ch-'0';
                if(val>largest){
                    largest=val;
                }
                else if(val<largest && val>secondlargest){
                    secondlargest=val;
                }
            }

        }
        return secondlargest;
        
    }
}