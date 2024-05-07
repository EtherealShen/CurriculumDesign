package src.Trie;

public class TrieNode {
    public TrieNode[] next = new TrieNode[26];
    public String E_word;
    public String C_word;
    public boolean isWord;
    public TrieNode() {
        isWord=false;
    }
}
