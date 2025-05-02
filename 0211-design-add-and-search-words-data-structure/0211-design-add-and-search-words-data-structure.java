class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();
        
    }
    
    public void addWord(String word) {
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            int i=ch-'a';
            if(node.children[i]==null){
                node.children[i]=new TrieNode();
            }
            node=node.children[i];
        }
        node.isEndOfWord=true;
        
    }
    
    public boolean search(String word) {
        TrieNode node=root;
        return dfs(word,0,node);
        
    }
    public boolean dfs(String word,int ind,TrieNode node){
        if(ind==word.length()){
            return node.isEndOfWord;
        }
        char ch=word.charAt(ind);
        if(ch=='.'){
            for(TrieNode child:node.children){
                if(child!=null && dfs(word,ind+1,child)){
                    return true;
                }
            }
            return false;
        }
        else{
            int i=ch-'a';
            if(node.children[i]==null){
                return false;
            }
            return dfs(word,ind+1,node.children[i]);
        }

    }
}
class TrieNode{
    TrieNode children[]=new TrieNode[26];
    boolean isEndOfWord=false;
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */