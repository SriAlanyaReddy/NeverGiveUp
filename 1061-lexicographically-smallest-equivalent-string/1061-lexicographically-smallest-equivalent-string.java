class DisjointSet {
    char[] parent;

    DisjointSet() {
        parent = new char[26];
        for (char ch = 'a'; ch <= 'z'; ch++) {
            parent[ch - 'a'] = ch;
        }
    }

    public char findparent(char x) {
        if (parent[x - 'a'] != x) {
            parent[x - 'a'] = findparent(parent[x - 'a']); // path compression
        }
        return parent[x - 'a'];
    }

    public void union(char x, char y) {
        char rootX = findparent(x);
        char rootY = findparent(y);

        if (rootX == rootY) return;

        // ⭐ lexicographically smaller becomes parent
        if (rootX < rootY) {
            parent[rootY - 'a'] = rootX;
        } else {
            parent[rootX - 'a'] = rootY;
        }
    }
}
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DisjointSet dsu = new DisjointSet();

        for (int i = 0; i < s1.length(); i++) {
            dsu.union(s1.charAt(i), s2.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            sb.append(dsu.findparent(ch));
        }

        return sb.toString();
    }
}
