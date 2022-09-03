package util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 画背景图
 */
public class BackImg extends JPanel{

    Image image;

    /**
     * 设置背景图片
     * @param imageSrc
     */
    public BackImg(String imageSrc){
        try {
            image = ImageIO.read(new File(imageSrc));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(image,0,0,null);
    }
}
