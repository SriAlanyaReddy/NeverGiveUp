class Solution {
public:
    int findMin(vector<int>& a) {
        	int ans=INT_MAX;
	int lb=0;
	int ub=a.size()-1;
	while(lb<=ub){
		int mid=(lb+ub)/2;
		if(a[lb]<=a[ub]){
			ans=min(ans,a[lb]);
			return ans;
		}
		if(a[lb]<=a[mid]){
			
			ans=min(a[lb],ans);
			 lb = mid + 1;
		}
		else{
			ans=min(a[mid],ans);
			ub=mid-1;

		}
	}
	return ans;
    }
};