class DisjointSet{
    int n;
    int parent[];
    DisjointSet(int n){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }
    public int findparent(int x){
        if(parent[x]!=x){
            parent[x]=findparent(parent[x]);
        }
        return parent[x];
    }
    public void union(int u,int v){
        int rootx=findparent(u);
        int rooty=findparent(v);
        if(rootx!=rooty){
            parent[rootx]=rooty;
        }
    }
}
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        DisjointSet ds=new DisjointSet(n);
        for(List<Integer> pair:pairs){
            ds.union(pair.get(0),pair.get(1));
        }
        Map<Integer,PriorityQueue<Character>>parent_characters=new HashMap<>();
        for(int i=0;i<n;i++){
            int parent=ds.findparent(i);
            if(!parent_characters.containsKey(parent)){
                parent_characters.put(parent,new PriorityQueue<>());
            }
            parent_characters.get(parent).add(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int parent=ds.findparent(i);
            sb.append(parent_characters.get(parent).poll());
        }
        return sb.toString();
    }
}