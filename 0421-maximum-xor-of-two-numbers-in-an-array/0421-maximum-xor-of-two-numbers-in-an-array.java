class Trie{
    TrieNode root=new TrieNode();
    public void insert(int n){
        TrieNode node=root;
        for(int i=31;i>=0;i--){
            int bit=(n>>i)&1;
            if(node.children[bit]==null){
                node.children[bit]=new TrieNode();
            }
            node=node.children[bit];

        }
    }
    public int findmax(int n){
        TrieNode node=root;
        int max=0;
        for(int i=31;i>=0;i--){
            int bit=(n>>i)&1;
            int togglebit=1-bit;
            if(node.children[togglebit]!=null){
                max|=1<<i;
                node=node.children[togglebit];
            }
            else{
                node=node.children[bit];
            }
        }
        return max;
    }

}
class TrieNode{
    TrieNode children[]=new TrieNode[2];
}
class Solution {
    public int findMaximumXOR(int[] a) {
        int n=a.length;
        Trie trie=new Trie();
        int max=0;
       for(int i=0;i<n;i++){
        trie.insert(a[i]);
        max=Math.max(trie.findmax(a[i]),max);

       }
       return max;
    }
}