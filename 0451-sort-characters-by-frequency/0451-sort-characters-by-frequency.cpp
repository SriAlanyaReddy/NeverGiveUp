class Solution {
public:
    string frequencySort(string s) {
       unordered_map<char,int>mp;
       for(int i=0;i<s.length();i++) {
           mp[s[i]]++;
       }
       vector<pair<int,char>>v;
    for (auto it = mp.begin(); it != mp.end(); ++it) {
            v.push_back({it->second, it->first});
        }
       sort(v.rbegin(),v.rend());
       vector<char>v1;
       string s1;
       for(auto i:v){
           s1=s1+string(i.first,i.second);//
    // Append the character 'pair.second' 'pair.first' times
       }
       return s1;
    }
};