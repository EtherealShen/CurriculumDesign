package src.Hash;

import java.util.LinkedList;

public class Hash {
    public HashNode[] arr;
    public LinkedList<String> list;
    public Hash()
    {
        arr = new HashNode[50];
        for(int i = 0; i < 50; i++)
            arr[i] = null;
        list = new LinkedList<>();
    }
    public String search(String E_word)
    {
        // (key.hashCode())^(h>>>16)
        int index = Math.abs(E_word.hashCode()) % 50;
        HashNode p;
        p = arr[index];
        while((p != null) && !(E_word.equals(p.E_word)))
            p = p.next;
        if(p == null)
            return "null";
        else
            return p.C_word;
    }
    public void insert(String E_word, String C_word){
        int index = Math.abs(E_word.hashCode()) % 50;
        HashNode p = arr[index];
        while(p != null)
            p = p.next;
        HashNode q = new HashNode();
        q.E_word = E_word;
        q.C_word = C_word;
        q.next = arr[index];
        arr[index] = q;
    }
    public void delete(String E_word)
    {
        int index = Math.abs(E_word.hashCode()) % 50;
        HashNode p = arr[index];
        if(p.E_word.equals(E_word))
        {
            arr[index] = p.next;
            return;
        }
        while(true)
        {
            HashNode q = p.next;
            if(q.E_word.equals(E_word))
            {
                p.next=q.next;
                break;
            }
            p=p.next;
        }
    }
    public void Print()
    {
        LinkedList<HashNode> nodeList = new LinkedList<>();
        for(int i = 0; i < 50; i++)
        {
            HashNode p = arr[i];
            while(p != null)
            {
                nodeList.add(p);
                p = p.next;
            }
        }
        HashNode p = nodeList.getLast();
        int last = nodeList.indexOf(p);
        for(int i = 0; i <= last; i++)
        {
            HashNode q = nodeList.get(i);
            list.add(q.E_word);
            list.add(q.C_word);
        }
    }
    public LinkedList<String> getList() {
        return list;
    }
}
