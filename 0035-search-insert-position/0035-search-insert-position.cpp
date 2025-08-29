#include <vector>

class Solution {
public:
    int searchInsert(vector<int>& a, int target) {
        int n = a.size();
        vector<int> p;

        for (int i = 0; i < n; i++) {
            if (a[i] < target) {
                p.push_back(a[i]);
            } else {
                // If the current element is greater than or equal to the target,
                // the correct position to insert the target is found.
                return i;
            }
        }

        // If we reach here, it means the target is greater than all elements in the vector.
        // Therefore, insert it at the end.
        return n;
    }
};
