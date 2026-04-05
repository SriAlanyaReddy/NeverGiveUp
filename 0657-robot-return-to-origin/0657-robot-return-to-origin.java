class Solution {
    public boolean judgeCircle(String moves) {
        int c=0;
        int a[]=new int[2];
        
        for(char ch:moves.toCharArray()){
            if(ch=='U'){
               a[0]++;
            }
            else if(ch=='D'){
                a[0]--;
            }
            else if(ch=='L'){
               a[1]++;
            }
            else if(ch=='R'){
                a[1]--;
            }

        }
       for(int i:a){
        if(i!=0)
            return false;
        
       }
       return true;
        
    }
}