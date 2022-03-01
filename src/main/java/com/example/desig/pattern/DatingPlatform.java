package com.example.desig.pattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhouyulong@uyaogui.com
 * @date 2021/11/24
 * description  中介者模式
 */
public class DatingPlatform {
    public static void main(String[] args) {
        //房产中介
        Medium md = new EstateMedium();    
        Customer member1, member2;
        member1 = new Seller("张三(卖方)");
        member2 = new Buyer("李四(买方)");
        //客户注册
        md.register(member1);
        md.register(member2);
    }
}

/**
 *
 * @author zhouyulong@uyaogui.com
 * @date 2021/11/24
 * description  TODO
 */
interface Medium {
    
    void register(Customer member);

    /**
     *
     * @author zhouyulong@uyaogui.com
     * @date 2021/11/24
     * description  TODO
     */
    void relay(String from, String ad);
}


/**
 *
 * @author zhouyulong@uyaogui.com
 * @date 2021/11/24
 * description  具体中介者：房地产中介
 */
class EstateMedium implements Medium {
    private List<Customer> members = new ArrayList<Customer>();

    @Override
    public void register(Customer member) {
        if (!members.contains(member)) {
            members.add(member);
            member.setMedium(this);
        }
    }

    @Override
    public void relay(String from, String ad) {
        for (Customer ob : members) {
            String name = ob.getName();
            if (!name.equals(from)) {
                ((Customer) ob).receive(from, ad);
            }
        }
    }
}

/**
 *
 * @author zhouyulong@uyaogui.com
 * @date 2021/11/24
 * description  TODO
 */
abstract class Customer extends JFrame implements ActionListener {
    private static final long serialVersionUID = -7219939540794786080L;
    protected Medium medium;
    protected String name;
    JTextField sentText;
    JTextArea receiveArea;

    public Customer(String name) {
        super(name);
        this.name = name;
    }

    void clientWindow(int x, int y) {
        Container cp;
        JScrollPane sp;
        JPanel p1, p2;
        cp = this.getContentPane();
        sentText = new JTextField(18);
        receiveArea = new JTextArea(10, 18);
        receiveArea.setEditable(false);
        p1 = new JPanel();
        p1.setBorder(BorderFactory.createTitledBorder("接收内容："));
        p1.add(receiveArea);
        sp = new JScrollPane(p1);
        cp.add(sp, BorderLayout.NORTH);
        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("发送内容："));
        p2.add(sentText);
        cp.add(p2, BorderLayout.SOUTH);
        sentText.addActionListener(this);
        this.setLocation(x, y);
        this.setSize(250, 330);
        //窗口大小不可调整
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tempInfo = sentText.getText().trim();
        sentText.setText("");
        this.send(tempInfo);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public abstract void send(String ad);

    public abstract void receive(String from, String ad);
}

/**
 *
 * @author zhouyulong@uyaogui.com
 * @date 2021/11/24
 * description  具体同事类：卖方
 */
class Seller extends Customer {
    private static final long serialVersionUID = -1443076716629516027L;

    public Seller(String name) {
        super(name);
        clientWindow(50, 100);
    }

    @Override
    public void send(String ad) {
        receiveArea.append("我(卖方)说: " + ad + "\n");
        //使滚动条滚动到最底端
        receiveArea.setCaretPosition(receiveArea.getText().length());
        medium.relay(name, ad);
    }

    @Override
    public void receive(String from, String ad) {
        receiveArea.append(from + "说: " + ad + "\n");
        //使滚动条滚动到最底端
        receiveArea.setCaretPosition(receiveArea.getText().length());
    }
}

/**
 *
 * @author zhouyulong@uyaogui.com
 * @date 2021/11/24
 * description  具体同事类：买方
 */
class Buyer extends Customer {
    private static final long serialVersionUID = -474879276076308825L;

    public Buyer(String name) {
        super(name);
        clientWindow(350, 100);
    }

    @Override
    public void send(String ad) {
        receiveArea.append("我(买方)说: " + ad + "\n");
        //使滚动条滚动到最底端
        receiveArea.setCaretPosition(receiveArea.getText().length());
        medium.relay(name, ad);
    }

    @Override
    public void receive(String from, String ad) {
        receiveArea.append(from + "说: " + ad + "\n");
        //使滚动条滚动到最底端
        receiveArea.setCaretPosition(receiveArea.getText().length());
    }
}