class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n=digits.length;
        int freq[]=new int[10];
        for(int i=0;i<n;i++){
            freq[digits[i]]++;

        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=100;i<=998;i+=2){
            int first=(i/10)/10;
            int second=(i/10)%10;
            int third=i%10;
            int tempfreq[]=new int[10];
            tempfreq[first]++;
            tempfreq[second]++;
            tempfreq[third]++;
            if(tempfreq[first]<=freq[first] && tempfreq[second]<=freq[second] && tempfreq[third]<=freq[third]){
                ans.add(i);
            }
        }
        int ans1[]=new int[ans.size()];
        int ind=0;
        for(int i=0;i<ans.size();i++){
            ans1[ind]=ans.get(i);
            ind++;
        }
        return ans1;

    }
}