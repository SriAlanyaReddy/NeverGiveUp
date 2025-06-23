class Solution {
public:
    bool exist(vector<vector<char>>& letters, string word) {
         
  int r=letters.size();
  int c=letters[0].size();
   vector<vector<bool>> visited(r, vector<bool>(c, false));
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            if (letters[i][j] == word[0] && dfs(letters, visited, word, 0, i, j, r, c)) {
                return true;
            }
        }
    }

    return false;
    }
    bool dfs(vector<vector<char>>& letters, vector<vector<bool>>& visited, string& word, int index, int x, int y, int r, int c) {
    if (index == word.length()) {
        return true;
    }
    if (x < 0 || x >= r || y < 0 || y >= c || letters[x][y] != word[index]|| visited[x][y] ) {
        return false;
    }

    visited[x][y] = true;

    // Explore all 4 possible directions (up, down, left, right)
    if (dfs(letters, visited, word, index + 1, x + 1, y, r, c) ||
        dfs(letters, visited, word, index + 1, x - 1, y, r, c) ||
        dfs(letters, visited, word, index + 1, x, y + 1, r, c) ||
        dfs(letters, visited, word, index + 1, x, y - 1, r, c)) {
        return true;
        }

    visited[x][y] = false;
    return false;
}
};