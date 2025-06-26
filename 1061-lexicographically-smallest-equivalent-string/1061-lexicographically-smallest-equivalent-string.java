class DisjointSet {
    int parent[];
    int rank[];

    DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findparent(int x) {
        if (parent[x] != x) {
            parent[x] = findparent(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootx = findparent(x);
        int rooty = findparent(y);

        if (rootx == rooty) return false;

        // ✅ Lexicographically smaller becomes parent
        if (rootx < rooty) {
        parent[rooty] = rootx;
    } else {
        parent[rootx] = rooty;
    }
        return true;
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
       DisjointSet dsu=new DisjointSet(26);
        int n=s1.length();
        for(int i=0;i<n;i++){
            int  ch1=s1.charAt(i)-'a';
            int ch2=s2.charAt(i)-'a';
            dsu.union(ch1,ch2);
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:baseStr.toCharArray()){
            int parent=dsu.findparent(ch-'a');
            sb.append((char)(parent+'a'));
            

        }
        return sb.toString();
        
    }
}