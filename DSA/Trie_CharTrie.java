package DSA;


import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] arr;
    int ends=0; // how many words end here
    int below=0; // how many words end here and below it
    // if no words end below this char then ends == below
    String word=""; // store the word here

    public TrieNode() {
        this.arr = new TrieNode[26];
    }
}

public class  Trie_CharTrie {
    private TrieNode root;

    public Trie_CharTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
               p.arr[index] = new TrieNode();
            //before going to the next char, we know that we are inserting a word which ends below
            p.below +=1;
            p = p.arr[index];
            }
        }
        p.ends += 1;
        p.word = word;

    }

    public boolean search(String word) {
        // check if word exits in trie
        TrieNode p = searchNode(word);
        if (p == null) {
            return false;
        } else {
            return p.ends >0;
        }
    }
    public List<String> getAllWords(String prefix){
        // get list of all words that start with prefix
        List<String> words = new ArrayList<>();
        TrieNode p = searchNode(prefix);
        if(p == null) return words; // return empty list

        // do dfs
        trie_dfs(p,words);
        return words;
    }

    private void trie_dfs(TrieNode p,List<String> words) {
        if( p ==null ) return;
        // if a words ends here store it in list
        if(p.ends >0) words.add(p.word);
        // check the children
        for( int i =0 ; i <26; i++)
        {
            trie_dfs(p.arr[i], words);
        }

    }


    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        return p != null;
    }

    public TrieNode searchNode(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (p.arr[index] != null) {
                p = p.arr[index];
            } else {
                return null;
            }
        }
        return p;
    }
}

