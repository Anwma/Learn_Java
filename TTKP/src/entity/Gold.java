package entity;

import javax.swing.*;
import java.awt.*;

/**
 * 金币
 */
public class Gold {

    public int x;
    public int y;

    public int width = 30;
    public int height = 30;

    Image image;

    public Gold(){
        //随机值的范围 0~1  [0,1)
        x=(int) (Math.random()*700)+200;//200~900
        y=(int) (Math.random()*360);

        //随机生成21~26
        int index = (int)(Math.random()*6)+21;

        image = new ImageIcon("image/"+index+".png").getImage();
    }

    /**
     * 绘制金币
     * @param g
     */
    public void paintGole(Graphics g){
        x--;
        g.drawImage(image,x,y,width,height,null);
    }

}
