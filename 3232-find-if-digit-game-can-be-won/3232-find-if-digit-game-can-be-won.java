class Solution {
    public boolean canAliceWin(int[] a) {
        int n=a.length;
        int doublesum=0,singlesum=0;
        for(int i=0;i<n;i++){
            int cnt=0;
            int temp=a[i];
            while(temp!=0){
                cnt++;
                temp=temp/10;
            }
            if(cnt==2){
                doublesum+=a[i];
            }
            if(cnt==1){
                singlesum+=a[i];
            }
        }
        return singlesum>doublesum|| doublesum>singlesum;
        
    }
}