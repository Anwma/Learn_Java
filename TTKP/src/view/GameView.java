package view;

import util.BackImg;
import util.BackMusic;
import util.GamePanel;

import javax.swing.*;

/**
 * 游戏界面
 */
public class GameView extends JFrame {

    public static void main(String[] args) {
        new GameView();
    }

    public GameView() {

        //3.背景音乐
//        new BackMusic("sound/十面埋伏-张艺兴.wav");

        //2.背景图片
        GamePanel gamePanel = new GamePanel();
        gamePanel.action();
        this.addKeyListener(gamePanel);//添加键盘监听事件
        this.add(gamePanel);

        //1.显示窗口
        //设置大小
        this.setSize(1000, 550);
        //设置位置 居中
        this.setLocationRelativeTo(null);
        //取消默认设置
        this.setUndecorated(true);
        //窗口是否显示
        this.setVisible(true);
        //任务栏图标
        this.setIconImage(new ImageIcon("image/115.png").getImage());
    }
}
