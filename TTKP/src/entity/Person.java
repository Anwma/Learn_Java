package entity;

import javax.swing.*;
import java.awt.*;

/**
 * 人物
 */
public class Person {

    public int x;
    public int y;

    public int width = 50;
    public int height = 80;

    //分数
    public int score = 0;

    //血量
    public int hp = 100;


    //数组脚标
    int index = 0;
    //图片切换条件
    int flag = 0;

    //人物图片
    Image p1,p2,p3,p4,p5,p6,p7,p8,p9;
    Image[] images = {};

    public Person(){
        x = 50;
        y = 350;
        init();
//        p1 = new ImageIcon("image/1.png").getImage();
    }


    /**
     * 图片初始化并存入数组
     */
    public void init(){
        p1 = new ImageIcon("image/1.png").getImage();
        p2 = new ImageIcon("image/2.png").getImage();
        p3 = new ImageIcon("image/3.png").getImage();
        p4 = new ImageIcon("image/4.png").getImage();
        p5 = new ImageIcon("image/5.png").getImage();
        p6 = new ImageIcon("image/6.png").getImage();
        p7 = new ImageIcon("image/7.png").getImage();
        p8 = new ImageIcon("image/8.png").getImage();
        p9 = new ImageIcon("image/9.png").getImage();

        //存入数组
        images = new Image[]{p1,p2,p3,p4,p5,p6,p7,p8,p9};
    }

    /**
     * 自定义绘制人物
     */
    public void paintPerson(Graphics g){
        g.drawImage(images[index],x,y,width,height,null);
        flag++;
        if (flag==10){
            flag = 0;
            index++;
            if (index>=9){
                index = 0;
            }
        }
    }
    /**
     * 人物自由下落的方法
     */
    public void drop(){
        if (y<=350){
            y+=2;
        }
    }
}
