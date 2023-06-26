package DSA;



class TrieNode {
    TrieNode[] arr;
    boolean isEnd;

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
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            } else {
                p = p.arr[index];
            }
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if (p == null) {
            return false;
        } else {
            return p.isEnd;
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

