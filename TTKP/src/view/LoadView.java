package view;

import util.BackImg;

import javax.swing.*;
import java.awt.*;

/**
 * 加载界面
 */
public class LoadView extends JFrame implements Runnable {

    //加载组件---进度条
    JProgressBar bar;

    public static void main(String[] args) {
        new LoadView().run();//启动线程
    }

    public LoadView() {

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
        this.setSize(568, 320);
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
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
                40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
                50, 51, 52, 53, 54, 55, 56, 57, 58, 59,
                60, 61, 62, 63, 64, 65, 66, 67, 68, 69,
                70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
                80, 81, 82, 83, 84, 85, 86, 87, 88, 89,
                90, 91, 92, 93, 94, 95, 96, 97, 98, 99,
                100};

        for (int i = 0; i < values.length; i++) {
            bar.setValue(values[i]);
            try {
                Thread.sleep(25);//设置睡眠时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //进度条加载完成，关闭当前页面，跳转到游戏页面
        this.dispose();
        new GameView();
    }
}
