/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int ans=-1;
        int right=n;
        int left=1;
        while(left<=right){
            int mid=(right-left)/2+left;
            if(isBadVersion(mid)){
                ans=mid;
                right=mid-1;

            }
            else {
                left=mid+1;


            }
        }
        return ans;
    }
}