package src.funtion;

import src.Trie.Trie;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class TrieFunction {
    public static HashMap<String,String> hashtable;
    public TrieFunction(){
        hashtable = new HashMap<>();
        // 读入单词
        readWords();
    }
    // 使用Trie实现查找
    public static String[] search(String word){
        Trie trie = new Trie();
        String[] resultAndTime = new String[2];
        String fileName = getFirstLetter(word);
        try {
            readDict(fileName, trie);
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("读写错误");
        }
        long startTime = System.nanoTime();
        String result = trie.search(word);
        long endTime = System.nanoTime();
        String time = String.valueOf((endTime - startTime));
        resultAndTime[0] = result;
        resultAndTime[1] = time;
        return resultAndTime;
    }
    // 使用Trie实现插入
    public static  String[] insert(String E_word,String C_word){
        String[] resultAndTime = new String[2];
        String[] res = search(E_word);
        if(res[0].equals("null")){
            long startTime = System.nanoTime();
            updateFile(E_word,C_word);
            long endTime = System.nanoTime();
            String time = String.valueOf((endTime - startTime));
            resultAndTime[0] = "插入成功";
            resultAndTime[1] = time;
            return resultAndTime;
        }else {
            resultAndTime[0] = "字典中已有该单词，请勿重复添加";
        }
        return resultAndTime;
    }
    // 使用Trie实现删除
    public static String[] delete(String E_word){
        String[] resultAndTime = new String[2];
        String[] res = search(E_word);
        if(!res[0].equals("null")){
            long startTime = System.nanoTime();
            updateFile(E_word,"");
            long endTime = System.nanoTime();
            String time = String.valueOf((endTime - startTime));
            resultAndTime[0] = "删除成功";
            resultAndTime[1] = time;
            return resultAndTime;
        }else {
            resultAndTime[0] = "字典中没有该单词，删除失败";
        }
        return resultAndTime;
    }

    public static void updateFile(String E_word, String C_word) {
        Trie trie = new Trie();
        String fileName = getFirstLetter(E_word);
        try {
            readDict(fileName, trie);
            if(C_word.isEmpty()){
                trie.delete(E_word);
            }else {
                trie.insert(E_word,C_word);
            }
            trie.traverse();
            LinkedList<String> list = trie.getList();
            Iterator<String> iterator = list.iterator();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            while(iterator.hasNext())
            {
                out.write(iterator.next());
                out.write("   ");
                out.write(iterator.next());
                out.newLine();
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("读写错误");
        }

    }

    public static void readDict(String fileName, Trie trie) throws IOException {
        File file = new File(fileName);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String[] line = in.readLine().split("\\s{1,5}");
        String e_word = line[0];
        String c_word = line[1];
        while(true)
        {
            trie.insert(e_word,c_word);
            String endLine = in.readLine();
            if(endLine==null){
                break;
            }
            line = endLine.split("\\s{1,5}");
            e_word = line[0];
            c_word = line[1];
        }
        in.close();
    }
    public static String getFirstLetter(String word){
        char[] wordString = word.toCharArray();
        String letter = new String(wordString,0,1);
        return hashtable.get(letter);
    }
    public static void readWords() {
        hashtable.put("a", "./\\dictionary\\a.txt");
        hashtable.put("b", "./\\dictionary\\b.txt");
        hashtable.put("c", "./\\dictionary\\c.txt");
        hashtable.put("d", "./\\dictionary\\d.txt");
        hashtable.put("e", "./\\dictionary\\e.txt");
        hashtable.put("f", "./\\dictionary\\f.txt");
        hashtable.put("g", "./\\dictionary\\g.txt");
        hashtable.put("h", "./\\dictionary\\h.txt");
        hashtable.put("i", "./\\dictionary\\i.txt");
        hashtable.put("j", "./\\dictionary\\j.txt");
        hashtable.put("k", "./\\dictionary\\k.txt");
        hashtable.put("l", "./\\dictionary\\l.txt");
        hashtable.put("m", "./\\dictionary\\m.txt");
        hashtable.put("n", "./\\dictionary\\n.txt");
        hashtable.put("o", "./\\dictionary\\o.txt");
        hashtable.put("p", "./\\dictionary\\p.txt");
        hashtable.put("q", "./\\dictionary\\q.txt");
        hashtable.put("r", "./\\dictionary\\r.txt");
        hashtable.put("s", "./\\dictionary\\s.txt");
        hashtable.put("t", "./\\dictionary\\t.txt");
        hashtable.put("u", "./\\dictionary\\u.txt");
        hashtable.put("v", "./\\dictionary\\v.txt");
        hashtable.put("w", "./\\dictionary\\w.txt");
        hashtable.put("x", "./\\dictionary\\x.txt");
        hashtable.put("y", "./\\dictionary\\y.txt");
        hashtable.put("z", "./\\dictionary\\z.txt");
    }
}
