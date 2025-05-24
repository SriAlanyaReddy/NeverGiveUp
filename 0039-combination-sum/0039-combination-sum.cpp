#include <vector>
using namespace std;

class Solution {
public:
    void findcombinations(int ind, int target, vector<int>& a, vector<vector<int>>& ans, vector<int>& ds, int n) {
        if (ind == n) {
            if (target == 0) {
                ans.push_back(ds);
            }
            return;
        }
        
        // Include the current element if it's not greater than the target
        if (a[ind] <= target) {
            ds.push_back(a[ind]);
            findcombinations(ind, target - a[ind], a, ans, ds, n);
            ds.pop_back(); // Backtrack
        }
        
        // Move to the next element
        findcombinations(ind + 1, target, a, ans, ds, n);
    }

    vector<vector<int>> combinationSum(vector<int>& a, int target) {
        vector<vector<int>> ans;
        vector<int> ds;
        int n = a.size();
        findcombinations(0, target, a, ans, ds, n);
        return ans;
    }
};
