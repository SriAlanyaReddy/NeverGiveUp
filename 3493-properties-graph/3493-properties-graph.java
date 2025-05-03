class DisJointSet{
    int parent[];
    int rank[];
    DisJointSet(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }
    public int findparent(int x){
        if(parent[x]!=x){
            parent[x]=findparent(parent[x]);
        }
        return parent[x];
    }
    public boolean Union(int x,int y){
        int rootx=findparent(x);
        int rooty=findparent(y);
        if(rootx==rooty){
            return false;
        }
        if(rank[rootx]>rank[rooty]){
            parent[rooty]=rootx;

        }
        else if(rank[rooty]>rank[rootx]){
            parent[rootx]=rooty;
        }
        else{
            parent[rootx]=rooty;
            rank[rooty]++;
        }
        return true;
    }
    public int intersect(int[] a, int[] b) {
    Set<Integer> setA = new HashSet<>();
    for (int num : a) setA.add(num);

    Set<Integer> common = new HashSet<>();
    for (int num : b) {
        if (setA.contains(num)) {
            common.add(num); // ensures uniqueness
        }
    }

    return common.size();
}

}
class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        int n=properties.length;
        DisJointSet dsu=new DisJointSet(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(dsu.intersect(properties[i],properties[j])>=k){
                    dsu.Union(i,j);
                }

            }
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(dsu.findparent(i)==i){
                c++;
            }
        }
        return c;
        
    }
}