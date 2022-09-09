package entity;

import javax.swing.*;
import java.awt.*;

/**
 * 导弹
 */
public class Missile {

    public int x;
    public int y;

    public int width = 50;
    public int height = 50;

    Image image;


    public Missile(){
        x=(int) (Math.random()*200)+800;
        y=(int)(Math.random()*400);

        image = new ImageIcon("image/daodan.png").getImage();
    }

    /**
     * 绘制导弹
     */
    public void paintMissile(Graphics g){
        x-=15;
        g.drawImage(image,x,y,width,height,null);
    }

}
