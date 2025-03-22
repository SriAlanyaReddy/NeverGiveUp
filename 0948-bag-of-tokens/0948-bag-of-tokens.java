class Solution {
    public int bagOfTokensScore(int[] tokens, int amount) {
        Arrays.sort(tokens);
        int n=tokens.length;
        int low=0;
        int high=n-1;
        int score=0;
        while(low<=high){
            if(tokens[low]<=amount){
                amount-=tokens[low];
                low++;
                score++;
            }
            else if(low<high && score>0){
                amount+=tokens[high];
                score--;
                high--;
            }
            else{
                return score;
            }
        }
        return score;
    }
}