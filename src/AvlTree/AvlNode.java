package src.AvlTree;

public class AvlNode {
    public String E_word;
    public String C_word;
    public AvlNode left;
    public AvlNode right;
    public int height;
    public AvlNode() {
        E_word = "";
        C_word = "";
        left = null;
        right = null;
        height = 0;
    }
    public AvlNode(String E_word, String C_word){
        this.E_word = E_word;
        this.C_word = C_word;
        left = null;
        right = null;
        height = 1;
    }
}
