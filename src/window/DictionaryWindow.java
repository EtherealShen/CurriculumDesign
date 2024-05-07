package src.window;

import src.funtion.AvlFunction;
import src.funtion.HashFunction;
import src.funtion.TrieFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DictionaryWindow extends JFrame implements ActionListener {
    public JTextField englishFiled,chineseFiled;
    public JButton hashSearchBtn,hashInsertBtn,hashDeleteBtn,PATSearchBtn,PATInsetBtn,PATDeleteBtn,AvlSearchBtn,AvlInsertBtn,AvlDeleteBtn,exitBtn;
    public JLabel titleLabel,promptLabel,chineseLabel,translateLabel,translate,status,timer;
    public JLabel hashLabel,PATLabel,AvlLabel;
    public BackgroundPanel container = new BackgroundPanel();
    public DictionaryWindow(){
        container.setLayout(null);
        setContentPane(container);
        setContent();
        setWindow();
        setEvent();

    }
    public void setWindow(){
        new HashFunction();
        new TrieFunction();
        new AvlFunction();
        this.setVisible(true);                                          //窗口可见
        this.setSize(800,680);                              //窗口大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            //窗口可关闭
        this.setLocationRelativeTo(null);                               //窗口居中
        this.setTitle("Dictionary");
    }
    public void setContent(){
        titleLabel = new JLabel("中英简易字典");
        titleLabel.setBounds(280,30,200,50);
        titleLabel.setFont(new Font("楷体",Font.PLAIN,28));

        // 英文输入框
        englishFiled = new JTextField(20);
        englishFiled.setBounds(290,90,230,30);

        // 中文输入框
        chineseFiled = new JTextField(20);
        chineseFiled.setBounds(290,140,230,30);

        promptLabel = new JLabel("请输入单词：");
        promptLabel.setBounds(150,80,200,50);
        promptLabel.setFont(new Font("楷体",Font.PLAIN,20));

        chineseLabel = new JLabel("请输入中文：");
        chineseLabel.setBounds(150,130,200,50);
        chineseLabel.setFont(new Font("楷体",Font.PLAIN,20));

        translateLabel = new JLabel("中文翻译：");
        translateLabel.setBounds(150,180,200,50);
        translateLabel.setFont(new Font("楷体",Font.PLAIN,20));

        // 状态
        status = new JLabel("状态：");
        status.setBounds(150,230,400,50);
        status.setFont(new Font("楷体",Font.PLAIN,20));

        // 耗时
        timer = new JLabel("耗时：");
        timer.setBounds(150,280,400,50);
        timer.setFont(new Font("楷体",Font.PLAIN,20));

        // 翻译结果
        translate = new JLabel();
        translate.setBounds(280,180,300,50);
        translate.setFont(new Font("楷体",Font.PLAIN,23));

        // 各数据结构比较
        hashLabel = new JLabel("散列表：");
        hashLabel.setBounds(150,350,300,50);
        hashLabel.setFont(new Font("楷体",Font.PLAIN,20));

        PATLabel = new JLabel("PAT：");
        PATLabel.setBounds(150,420,300,50);
        PATLabel.setFont(new Font("楷体",Font.PLAIN,20));

        AvlLabel = new JLabel("Avl：");
        AvlLabel.setBounds(150,490,300,50);
        AvlLabel.setFont(new Font("楷体",Font.PLAIN,20));

        // 散列表的操作
        hashSearchBtn = new JButton("查找");
        hashSearchBtn.setBounds(250,350,80,40);
        hashSearchBtn.setFont(new Font("楷体",Font.PLAIN,20));

        hashInsertBtn = new JButton("插入");
        hashInsertBtn.setBounds(370,350,80,40);
        hashInsertBtn.setFont(new Font("楷体",Font.PLAIN,20));

        hashDeleteBtn = new JButton("删除");
        hashDeleteBtn.setBounds(490,350,80,40);
        hashDeleteBtn.setFont(new Font("楷体",Font.PLAIN,20));

        // PAT树的操作
        PATSearchBtn = new JButton("查找");
        PATSearchBtn.setBounds(250,420,80,40);
        PATSearchBtn.setFont(new Font("楷体",Font.PLAIN,20));

        PATInsetBtn = new JButton("插入");
        PATInsetBtn.setBounds(370,420,80,40);
        PATInsetBtn.setFont(new Font("楷体",Font.PLAIN,20));

        PATDeleteBtn = new JButton("删除");
        PATDeleteBtn.setBounds(490,420,80,40);
        PATDeleteBtn.setFont(new Font("楷体",Font.PLAIN,20));

        // Avl树操作
        AvlSearchBtn = new JButton("查找");
        AvlSearchBtn.setBounds(250,490,80,40);
        AvlSearchBtn.setFont(new Font("楷体",Font.PLAIN,20));

        AvlInsertBtn = new JButton("插入");
        AvlInsertBtn.setBounds(370,490,80,40);
        AvlInsertBtn.setFont(new Font("楷体",Font.PLAIN,20));

        AvlDeleteBtn = new JButton("删除");
        AvlDeleteBtn.setBounds(490,490,80,40);
        AvlDeleteBtn.setFont(new Font("楷体",Font.PLAIN,20));

        // 退出按钮
        exitBtn = new JButton("退出");
        exitBtn.setBounds(370,570,80,40);
        exitBtn.setFont(new Font("楷体",Font.PLAIN,20));

        container.add(titleLabel);
        container.add(englishFiled);
        container.add(chineseFiled);

        container.add(promptLabel);
        container.add(chineseLabel);
        container.add(translateLabel);
        container.add(translate);
        container.add(status);
        container.add(timer);
        container.add(hashLabel);
        container.add(PATLabel);
        container.add(AvlLabel);

        container.add(hashSearchBtn);
        container.add(hashInsertBtn);
        container.add(hashDeleteBtn);
        container.add(PATSearchBtn);
        container.add(PATInsetBtn);
        container.add(PATDeleteBtn);
        container.add(AvlSearchBtn);
        container.add(AvlInsertBtn);
        container.add(AvlDeleteBtn);
        container.add(exitBtn);

    }
    public void setEvent(){
        hashSearchBtn.addActionListener(this);
        hashInsertBtn.addActionListener(this);
        hashDeleteBtn.addActionListener(this);
        PATSearchBtn.addActionListener(this);
        PATInsetBtn.addActionListener(this);
        PATDeleteBtn.addActionListener(this);
        AvlSearchBtn.addActionListener(this);
        AvlInsertBtn.addActionListener(this);
        AvlDeleteBtn.addActionListener(this);
        exitBtn.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        String[] resultAndTime;
        String enWord = englishFiled.getText();
        String zhWord = chineseFiled.getText();
        clearInfo();
        if(checkInput()){
            if (e.getSource() == hashSearchBtn) {
                resultAndTime = HashFunction.search(enWord);
                if(resultAndTime[0].equals("null")){
                    status.setText("状态："+"     查找失败，单词不存在");
                }else{
                    translate.setText(resultAndTime[0]);
                    setStatus("查找成功",resultAndTime[1]);
                }
            }
            if (e.getSource() == hashInsertBtn) {
                if(!zhWord.isEmpty()){
                    resultAndTime = HashFunction.insert(enWord,zhWord);
                    if(resultAndTime[0].equals("插入成功")){
                        setStatus("插入成功",resultAndTime[1]);
                    }else{
                        status.setText("状态："+"   "+resultAndTime[0]);
                    }
                }else{
                    status.setText("状态："+"     插入失败 请输入中文");
                }
            }
            if (e.getSource() == hashDeleteBtn) {
                resultAndTime = HashFunction.delete(enWord);
                if(resultAndTime[0].equals("删除成功")){
                    setStatus("删除成功",resultAndTime[1]);
                }else{
                    status.setText("状态："+"   "+resultAndTime[0]);
                }
            }
            if (e.getSource() == PATSearchBtn) {
                resultAndTime = TrieFunction.search(enWord);
                if(resultAndTime[0].equals("null")){
                    status.setText("状态："+"     查找失败，单词不存在");
                } else{
                    translate.setText(resultAndTime[0]);
                    setStatus("查找成功",resultAndTime[1]);
                }
            }
            if(e.getSource()==PATInsetBtn){
                if (!zhWord.isEmpty()){
                    resultAndTime = TrieFunction.insert(enWord,zhWord);
                    if(resultAndTime[0].equals("插入成功")){
                        setStatus("插入成功",resultAndTime[1]);
                    }else{
                        status.setText("状态："+"   "+resultAndTime[0]);
                    }
                }else{
                    status.setText("状态："+"     插入失败 请输入中文");
                }
            }
            if(e.getSource()==PATDeleteBtn){
                resultAndTime = TrieFunction.delete(enWord);
                if(resultAndTime[0].equals("删除成功")){
                    setStatus("删除成功",resultAndTime[1]);
                }else{
                    System.out.println(resultAndTime[0]);
                    status.setText("状态："+"   "+resultAndTime[0]);
                }
            }
            if (e.getSource() == AvlSearchBtn) {
                resultAndTime = AvlFunction.search(enWord);
                if(resultAndTime[0].equals("null")){
                    status.setText("状态："+"     查找失败，单词不存在");
                }else{
                    translate.setText(resultAndTime[0]);
                    setStatus("查找成功",resultAndTime[1]);
                }
            }
            if (e.getSource() == AvlInsertBtn) {
                if(!zhWord.isEmpty()){
                    resultAndTime = AvlFunction.insert(enWord,zhWord);
                    if(resultAndTime[0].equals("插入成功")){
                        setStatus("插入成功",resultAndTime[1]);
                    }else{
                        status.setText("状态："+"   "+resultAndTime[0]);
                    }
                }else{
                    status.setText("状态："+"     插入失败 请输入中文");
                }
            }
            if(e.getSource()==AvlDeleteBtn){
                resultAndTime = AvlFunction.delete(enWord);
                if(resultAndTime[0].equals("删除成功")){
                    setStatus("删除成功",resultAndTime[1]);
                }else{
                    System.out.println(resultAndTime[0]);
                    status.setText("状态："+"   "+resultAndTime[0]);
                }
            }
        }else{
            status.setText("状态："+"       您输入的格式有误");
        }
        if(e.getSource() == exitBtn){
            System.out.println("执行退出操作");
            dispose();
        }
    }
    public boolean checkInput(){
        String enWord = englishFiled.getText();
        return enWord.matches("[a-zA-Z]+");
    }
    public void setStatus(String state,String time){
        double t = Double.parseDouble(time);
        status.setText("状态："+"       "+state);
        if(t/1000<0){
            timer.setText("耗时："+"       "+t+"纳秒");
        }else {
            timer.setText("耗时："+"       "+t/1000+"微秒");
        }
    }
    public void clearInfo(){
        translate.setText("");
        status.setText("状态：");
        timer.setText("耗时：");
    }
}
