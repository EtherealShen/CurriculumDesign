package src.Trie;

import java.util.LinkedList;

public class Trie {
    public TrieNode root;
    public LinkedList<String> list;
    public Trie(){
        root = new TrieNode();
        list = new LinkedList<>();
    }
    public String search(String E_word){
        TrieNode cur = root;
        E_word = E_word.replace("-","").replace(".","")
                .replace("/","");
        for (int i = 0; i < E_word.length(); i++) {
            int index = E_word.charAt(i) - 'a';
            if(index<0){
                index+=32;
            }
            if(cur.next[index]==null){
                return "null";
            }
            cur = cur.next[index];
        }
        if(cur.isWord)
            return cur.C_word;
        else
            return "null";
    }
    public void insert(String E_word,String C_word){
        TrieNode cur = root;
        E_word = E_word.replace("-","").replace(".","")
                .replace("/","");
        for (int i = 0; i < E_word.length(); i++) {
            int index = E_word.charAt(i) - 'a';
            if(index < 0){
                index += 32;
            }
            if (cur.next[index] == null){
                cur.next[index] = new TrieNode();
            }
            cur = cur.next[index];
        }
        cur.isWord = true;
        cur.C_word = C_word;
        cur.E_word = E_word;
    }
    public void delete(String E_word)
    {
        TrieNode cur = root;
        for(int i = 0; i < E_word.length(); i++){
            int index = E_word.charAt(i) - 'a';
            if(index < 0){
                index += 32;
            }
            cur = cur.next[index];
        }
        cur.isWord = false;
    }

    private void traverse(TrieNode root){
        if(root==null){
            return;
        }
        for(int i=0;i<26;i++){
            traverse(root.next[i]);
            if(root.isWord)
            {
                list.add(root.E_word);
                list.add(root.C_word);
                root.isWord = false;
            }
        }
    }
    public void traverse(){
        for (int i = 0; i < 26; i++) {
            traverse(root.next[i]);
        }
    }
    public LinkedList<String> getList(){
        return list;
    }
}
