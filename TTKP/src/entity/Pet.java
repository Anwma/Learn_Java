package entity;

import javax.swing.*;
import java.awt.*;

/**
 * 宠物
 */
public class Pet {

    //设置宠物的初始位置
    public int x;
    public int y;

    //设置宠物图片的大小
    public int width = 50;
    public int height = 50;

    Image p1, p2, p3, p4, p5, p6;
    Image[] images = {};

    //数组脚标
    int index = 0;
    //图片切换条件
    int flag = 0;

    public Pet() {
        x = 120;
        y = 385;
//        p1 = new ImageIcon("image/d1.png").getImage();
        init();
    }

    /**
     * 图片初始化并存入数组
     */
    public void init() {
        p1 = new ImageIcon("image/d1.png").getImage();
        p2 = new ImageIcon("image/d2.png").getImage();
        p3 = new ImageIcon("image/d3.png").getImage();
        p4 = new ImageIcon("image/d4.png").getImage();
        p5 = new ImageIcon("image/d5.png").getImage();
        p6 = new ImageIcon("image/d6.png").getImage();

        //存入数组
        images = new Image[]{p1, p2, p3, p4, p5, p6};
    }

    /**
     * 宠物绘制工具
     */
    public void paintPet(Graphics g) {
        g.drawImage(images[index], x, y, width, height, null);
        flag++;
        if (flag == 10) {
            flag = 0;
            index++;
            if (index >= 6) {
                index = 0;
            }
        }
    }

    /**
     * 宠物自由下落的方法
     */
    public void drop() {
        if (y <= 385) {
            y += 2;
        }
    }
}
