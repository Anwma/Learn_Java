package view;

import util.BackImg;
import util.Mic;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 菜单界面
 */
public class MenuView extends JFrame implements MouseListener{

    //开始游戏
    JLabel startLabel;

    //帮助
    JLabel helpLabel;

    //退出
    JLabel exitLabel;

    public static void main(String[] args) {
        new MenuView();
    }

    public MenuView(){

        //4.按钮------开始游戏  帮助  退出
        //开始游戏
        startLabel = new JLabel(new ImageIcon("image/hh1.png"));
        startLabel.setBounds(340,280,200,40);
        startLabel.setEnabled(true);
        startLabel.addMouseListener(this);//绑定鼠标监听
        this.add(startLabel);

        //帮助
        helpLabel = new JLabel(new ImageIcon("image/hh2.png"));
        helpLabel.setBounds(340,340,200,40);
        helpLabel.setEnabled(true);
        helpLabel.addMouseListener(this);//绑定鼠标监听
        this.add(helpLabel);

        //退出
        exitLabel = new JLabel(new ImageIcon("image/hh3.png"));
        exitLabel.setBounds(340,400,200,40);
        exitLabel.setEnabled(true);
        exitLabel.addMouseListener(this);//绑定鼠标监听
        this.add(exitLabel);


        //3.设置背景音乐
//        new Mic("sound/十面埋伏-张艺兴.mp3");

        //2.设置背景图片
        BackImg backImg = new BackImg("image/main.png");
        this.add(backImg);

        //1.显示窗口
        //设置显示窗口大小
        this.setSize(1136,640);
        //设置窗口位置  屏幕中心
        this.setLocationRelativeTo(null);
        //取消默认效果
        this.setUndecorated(true);
        //设置窗口是否需要显示
        this.setVisible(true);
        //设置任务栏图标
        this.setIconImage(new ImageIcon("image/115.png").getImage());
    }

    /**
     * 鼠标点击
     */
    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.println("鼠标点击");
        if (e.getSource()==startLabel){
            //关闭当前界面
            this.dispose();

            //打开加载界面
            new Thread(new LoadView()).start();

        }else if (e.getSource()==helpLabel){
            JOptionPane.showMessageDialog(this,"WASD控制方向，吃金币得分，炸弹掉血");
        }else {
//            exitLabel
            System.exit(0);
        }
    }

    /**
     * 鼠标按下
     */
    @Override
    public void mousePressed(MouseEvent e) {
//        System.out.println("鼠标按下");
        if (e.getSource()==startLabel){
            startLabel.setEnabled(false);
        }else if (e.getSource()==helpLabel){
            helpLabel.setEnabled(false);
        }else {
            exitLabel.setEnabled(false);
        }

    }

    /**
     * 鼠标抬起
     */
    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("鼠标抬起");
        if (e.getSource()==startLabel){
            startLabel.setEnabled(true);
        }else if (e.getSource()==helpLabel){
            helpLabel.setEnabled(true);
        }else {
            exitLabel.setEnabled(true);
        }
    }

    /**
     * 鼠标移入
     */
    @Override
    public void mouseEntered(MouseEvent e) {
//        System.out.println("鼠标移入");
    }

    /**
     * 鼠标移出
     */
    @Override
    public void mouseExited(MouseEvent e) {
//        System.out.println("鼠标移出");
    }
}
