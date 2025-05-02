
import java.util.* ;
import java.io.*; 
public class Trie {
    TrieNode root;
    public Trie() {
        // Write your code here.
        root=new TrieNode();
    }

    public void insert(String word) {
        // Write your code here.
        TrieNode node=root;
        for(char ch:word.toCharArray()){
            int i=ch-'a';
            if(node.children[i]==null){
                node.children[i]=new TrieNode();
            }
            node=node.children[i];
            node.increasePrefixcount();
        }
        node.isEndofWord=true;
        node.increaseEqual();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        TrieNode node=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            int in=ch-'a';
            if(node.children[in]==null){
                return 0;
            }
            else{
                node=node.children[in];
            }
        }
        return node.counteq;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        TrieNode node=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            int ind=ch-'a';
            if(node.children[ind]==null){
                return 0;
            }
            else{
                node=node.children[ind];
            }
        }
        return node.countprefix;

    }

    public void erase(String word) {

        // Write your code here.
        TrieNode node=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            int ind=ch-'a';
            if(node.children[ind]!=null){
                node=node.children[ind];
                node.decreaseprefix();
            }
            else{
               return;
            }
            
        }
        node.decreaseEqual();
    }
  
}
class TrieNode{
    TrieNode  children[]=new TrieNode[26];
    int countprefix=0;
    int counteq=0;

    boolean isEndofWord=false;
      public void increasePrefixcount(){
        countprefix++;
    }
    public void increaseEqual(){
        counteq++;
    }
    public void decreaseprefix(){
        countprefix--;
    }

public void decreaseEqual(){
    counteq--;
}

}
