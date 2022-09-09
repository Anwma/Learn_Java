package view;

import util.BackImg;

import javax.swing.*;
import java.awt.*;

/**
 * 加载界面
 */
public class LoadView extends JFrame implements Runnable{

    //加载组件---进度条
    JProgressBar bar;

    public static void main(String[] args) {
        new LoadView().run();//启动线程
    }

    public LoadView(){

        //3.进度条
        bar = new JProgressBar();
//        bar.setValue(50);//设置加载进度
//        bar.setBackground(Color.MAGENTA);//设置进度条的背景色
        bar.setStringPainted(true);//设置进度条提示
        this.add(bar, BorderLayout.SOUTH);


        //2.设置背景图片
        BackImg backImg = new BackImg("image/hbg.jpg");
        this.add(backImg);

        //1.显示窗口
        //设置窗口大小
        this.setSize(568,320);
        //窗口位置
        this.setLocationRelativeTo(null);
        //取消默认效果
        this.setUndecorated(true);
        //设置窗口是否显示
        this.setVisible(true);
        //设置任务栏的图标
        this.setIconImage(new ImageIcon("image/115.png").getImage());

    }


    @Override
    public void run() {
        int[] values = {10,20,35,55,68,97,99,100};

        for (int i=0;i<values.length;i++){
            bar.setValue(values[i]);
            try {
                Thread.sleep(500);//设置睡眠时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //进度条加载完成，关闭当前页面，跳转到游戏页面
        this.dispose();
        new GameView();

    }
}
