class TrieNode{
    TrieNode children[]=new TrieNode[26];
    boolean isEndOfWord=false;
}
class Trie{
    TrieNode root=new TrieNode();
    public void insert(String word){
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
    public boolean isValidPrefix(String word){
        TrieNode node=root;
        for(int i=0;i<word.length()-1;i++){
            char ch=word.charAt(i);
            int in=ch-'a';
            if(node.children[in]==null || !node.children[in].isEndOfWord){
                return false;
            }
            node=node.children[in];

        }
        return true;
    }
}
class Solution {
    public String longestWord(String[] words) {
        Trie trie=new Trie();
        for(String word:words){
            trie.insert(word);
        }
        String longestword="";
        for(String word:words){
            if(trie.isValidPrefix(word)){
                if((longestword.length()<word.length()) || (longestword.length()==word.length() && word.compareTo(longestword)<0)){
                    longestword=word;
                }

            }
        }
        return longestword;
    }
}
