class DisjointSet{
    char parent[];
    DisjointSet(){
       
        parent=new char[26];
        for (char ch = 'a'; ch <= 'z'; ch++) {
            parent[ch - 'a'] = ch; // Each character is its own parent initially
        }
    }
    public char findparent(char x){
        if(parent[x-'a']!=x){
            parent[x-'a']=findparent(parent[x-'a']);
        }
        return parent[x-'a'];
    }
    public void union(char x,char y){
        char rootx=findparent(x);
        char rooty=findparent(y);
        if(rootx!=rooty){
            parent[rootx-'a']=rooty;
        }
    }

}
class Solution {
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds=new DisjointSet();
        char res[]=new char[2];
        boolean flag=true;
        for(int i=0;i<equations.length;i++){
            String firstString=equations[i];
            char firstchar=firstString.charAt(0);
            char midchar=firstString.charAt(1);
            char lastchar=firstString.charAt(3);
            if(midchar=='='){
                ds.union(firstchar,lastchar);
            }
           

        }
        int n=equations.length;
      for(int i=0;i<n;i++){
        String firstString=equations[i];
            char firstchar=firstString.charAt(0);
            char midchar=firstString.charAt(1);
            char lastchar=firstString.charAt(3);
            if(midchar=='!' && ds.findparent(firstchar)==ds.findparent(lastchar)){
                return false;
            }
      }
      return true;
    }
}