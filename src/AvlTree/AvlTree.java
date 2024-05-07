package src.AvlTree;

import java.util.LinkedList;
public class AvlTree {
    private AvlNode root;
    private LinkedList<String> list;
    public AvlTree() {
        root = null;
        list = new LinkedList<String>();
    }
    //返回平衡因子
        private int getBalanceFactor(AvlNode node) {
        if(node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }
    // 返回节点高度
    public int getHeight(AvlNode node){
        if(node == null)
            return 0;
        return node.height;
    }
    //右旋
    public AvlNode rightRotate(AvlNode node) {
        AvlNode p = node.left;
        AvlNode q = p.right;
        p.right = node;
        node.left = q;
        //更新高度
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        return p;
    }
    //左旋
    public AvlNode leftRotate(AvlNode node) {
        AvlNode p = node.right;
        AvlNode q = p.left;
        p.left = node;
        node.right = q;
        //更新高度
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        return p;
    }
    private AvlNode insert(AvlNode node, String E_word, String C_word) {
        if(node == null)
            return new AvlNode(E_word, C_word);
        if(E_word.compareTo(node.E_word) < 0)
            node.left = insert(node.left, E_word, C_word);
        else if(E_word.compareTo(node.E_word) > 0)
            node.right = insert(node.right, E_word, C_word);
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        int balanceFactor = getBalanceFactor(node);
        if(balanceFactor > 1 && getBalanceFactor(node.left) > 0)    //LL型，右旋
            return rightRotate(node);
        if(balanceFactor < -1 && getBalanceFactor(node.right) < 0)  //RR型，左旋
            return leftRotate(node);
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0)	//LR型，先左旋，再右旋
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0)	//RL型，先右旋，再左旋
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    public void insert(String E_word, String C_word) {
        root = insert(root, E_word, C_word);
    }
    private String search(AvlNode node, String E_word) {
        if (node==null) {
            return "null";
        }
        if(E_word.compareTo(node.E_word) < 0)
            return search(node.left, E_word);
        else if(E_word.compareTo(node.E_word) > 0)
            return search(node.right, E_word);
        else
            return node.C_word;
    }
    public String search(String E_word) {
        if (search(root, E_word).isEmpty()) {
            return "null";
        }
        return search(root, E_word);
    }
    private void Print(AvlNode node)
    {
        if(node == null)
            return;
        Print(node.left);
        list.add(node.E_word);
        list.add(node.C_word);
        Print(node.right);
    }
    public LinkedList<String> getList() {
        return list;
    }
    public void Print()
    {
        Print(root);
    }
    //删除
    //四种情况：1-左子树为空；2-右子树为空；3-左右子树均不为空；4-左右子树均为空
    private AvlNode delete(AvlNode node, String E_word){
        if( node == null)
            return null;
        AvlNode retNode;
        if( E_word.compareTo(node.E_word) < 0 ){
            node.left = delete(node.left , E_word);
            retNode = node;
        }
        else if(E_word.compareTo(node.E_word) > 0 ){
            node.right = delete(node.right,E_word);
            retNode = node;
        }
        else{   // E_word.compareTo(node.E_word) == 0
            // 待删除节点左子树为空的情况
            if(node.left == null){
                AvlNode rightNode = node.right;
                node.right = null;
                retNode = rightNode;
            }
            // 待删除节点右子树为空的情况
            else if(node.right == null){
                AvlNode leftNode = node.left;
                node.left = null;
                retNode = leftNode;
            }else if(node.right == null && node.left == null)
            {
                retNode = null;
            }else {
                // 待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                AvlNode successor = minimum(node.right);
                successor.right = delete(node.right, successor.E_word);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }
        if(retNode==null)
            return null;
        //维护平衡
        //更新height
        retNode.height = 1+Math.max(getHeight(retNode.left),getHeight(retNode.right));
        //计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        if(balanceFactor > 1 && getBalanceFactor(retNode.left)>0) {
            //右旋LL
            return rightRotate(retNode);
        }
        if(balanceFactor < -1 && getBalanceFactor(retNode.right)<0) {
            //左旋RR
            return leftRotate(retNode);
        }
            //LR
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
            node.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
            //RL
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            node.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
    }
    //返回删除节点右子树的最小结点
    private AvlNode minimum(AvlNode node)
    {
        while(node.left != null)
        {
            node = node.left;
        }
        return node;
    }
    public void delete(String E_word)
    {
        root = delete(root, E_word);
    }
}
