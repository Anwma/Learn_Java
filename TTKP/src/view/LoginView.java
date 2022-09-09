package view;

import service.IUserService;
import service.impl.UserServiceImpl;
import util.BackImg;
import util.Mic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登录界面
 */
public class LoginView extends JFrame implements ActionListener {

    //账号
    JLabel userLabel;
    //密码
    JLabel pwdLabel;

    //账号输入框
    JTextField userText;
    //密码输入框
    JPasswordField pwdText;

    //登录按钮
    JButton logBtn;
    //取消按钮
    JButton cancelBtn;


    public static void main(String[] args) {
        new LoginView();
    }

    public LoginView(){

        //6.按钮
        //登录按钮
        logBtn = new JButton("登录");
        logBtn.setBounds(90,210,80,40);
        logBtn.addActionListener(this);
        this.add(logBtn);

        //取消按钮
        cancelBtn = new JButton("取消");
        cancelBtn.setBounds(180,210,80,40);
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        //5.输入框
        //账号输入框
        userText = new JTextField();
        userText.setBounds(90,130,100,30);
        this.add(userText);

        //密码输入框
        pwdText = new JPasswordField();
        pwdText.setBounds(90,170,100,30);
        this.add(pwdText);

        //4.title
        //账号title
        userLabel = new JLabel("账号");
        //设置位置、大小
        userLabel.setBounds(40,130,30,30);
        //添加到容器
        this.add(userLabel);

        //密码title
        pwdLabel = new JLabel("密码");
        //设置位置、大小
        pwdLabel.setBounds(40,170,30,30);
        //添加到容器
        this.add(pwdLabel);


        //3.设置背景音乐
//        BackMusic backMusic = new BackMusic("sound/lalala.wav");
//        new MyAudioPlayer("sound/十面埋伏-张艺兴.wav").play();
//        new Mic("sound/十面埋伏-张艺兴.mp3");//播放.mp3格式的音乐

        //2.设置背景图
        BackImg backImg = new BackImg("image/login.jpg");
        this.add(backImg);//添加组件

        //1.显示窗口
        //设置显示窗口的大小
        this.setSize(599,330);
        //设置组件相对位置，设置为null，那么窗口就会居中显示
        this.setLocationRelativeTo(null);
        //取消默认效果
        this.setUndecorated(true);
        //设置窗口显示
        this.setVisible(true);
        //设置任务栏小图标
        this.setIconImage(new ImageIcon("image/115.png").getImage());

    }


    //多态
    IUserService userService = new UserServiceImpl();
    @Override
    public void actionPerformed(ActionEvent e) {
        //判断你点击的哪一个按钮
        if (e.getSource()==logBtn){//登录按钮
            System.out.println("登录");
            String user = userText.getText();
            String pwd = pwdText.getText();

            System.out.println("user= "+user);
            System.out.println("pwd= "+pwd);

            //调用方法并加密密码
            boolean flag = userService.checkUsernameAndPassword(user, pwd);
            System.out.println("flag= "+flag);

            if (flag==true){//如果flag为true 账号密码正确 登录成功

                System.out.println("登录成功");

                //关闭当前界面
                this.dispose();

                //跳转菜单界面
                new MenuView();

            }else {//如果flag为false 账号密码错误  做出提示
                System.out.println("账号密码错误");
                JOptionPane.showMessageDialog(this,"账号密码错误");
            }

        }else if(e.getSource()==cancelBtn){//取消按钮
            System.out.println("取消");
            System.exit(0);
        }
    }
}
