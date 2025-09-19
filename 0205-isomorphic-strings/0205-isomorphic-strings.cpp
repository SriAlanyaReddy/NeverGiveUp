#include <iostream>
#include <unordered_map>
class Solution {
public:
bool isIsomorphic(string s,string t) {
    

    std::unordered_map<char, char> sToTMapping;
    std::unordered_map<char, char> tToSMapping;

    for (int i = 0; i < s.length(); ++i) {
        char charS = s[i];
        char charT = t[i];

        // Check if the character in s is already mapped
        if (sToTMapping.find(charS) != sToTMapping.end()) {
            // If it is mapped, make sure it is mapped to the same character in t
            if (sToTMapping[charS] != charT) {
                return false;  // Mapping conflict
            }
        } else {
            // If the character in s is not yet mapped, map it to the corresponding character in t
            sToTMapping[charS] = charT;
        }

        // Check if the character in t is already mapped
        if (tToSMapping.find(charT) != tToSMapping.end()) {
            // If it is mapped, make sure it is mapped to the same character in s
            if (tToSMapping[charT] != charS) {
                return false;  // Mapping conflict
            }
        } else {
            // If the character in t is not yet mapped, map it to the corresponding character in s
            tToSMapping[charT] = charS;
        }
    }

    return true;
}
};

