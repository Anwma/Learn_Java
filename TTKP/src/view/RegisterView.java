package view;

import service.IUserService;
import service.impl.UserServiceImpl;
import util.BackImg;
import util.Mic;
import util.MyAudioPlayer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 注册界面
 */
public class RegisterView extends JFrame implements ActionListener {

    //账号
    JLabel userLabel;
    //密码
    JLabel pwdLabel;

    //账号输入框
    JTextField userText;
    //密码输入框
    JPasswordField pwdText;

    //注册按钮
    JButton regBtn;
    //取消按钮
    JButton cancelBtn;


    public static void main(String[] args) {
        new RegisterView();
    }

    public RegisterView(){

        //6.按钮
        //注册按钮
        regBtn = new JButton("注册");
        regBtn.setBounds(90,210,80,40);
        regBtn.addActionListener(this);
        this.add(regBtn);

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
//        BackMusic backMusic = new BackMusic("sound/game.wav");
        new MyAudioPlayer("sound/game.wav").play();
//        new Mic("sound/game.mp3");//播放.mp3格式的音乐

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
        if (e.getSource()==regBtn){//注册按钮
            System.out.println("注册");
            String user = userText.getText();
            String pwd = pwdText.getText();

            System.out.println("user= "+user);
            System.out.println("pwd= "+pwd);

            //调用方法并加密密码
            userService.addUser(user,pwd);

            //关闭当前界面
            this.dispose();

            //跳转登录界面
            new LoginView();

        }else if(e.getSource()==cancelBtn){//取消按钮
            System.out.println("取消");
            System.exit(0);
        }
    }
}
