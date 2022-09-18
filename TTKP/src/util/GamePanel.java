package util;


import entity.Gold;
import entity.Missile;
import entity.Person;
import entity.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏界面绘制工具
 */
public class GamePanel extends JPanel implements KeyListener {

    //游戏背景图片
    Image image;
    int imageX = 0;

    //人物
    Person person;

    //分数
    Image source;

    //血量
    Image HP;

    //宠物
    Pet pet;

    //金币
//    Gold gold;
    List<Gold> golds = new ArrayList<>();
    int goldIndex = 0;

    //导弹
//    Missile missile;
    List<Missile> missiles = new ArrayList<>();
    int missileIndex = 0;

    public GamePanel() {
        image = new ImageIcon("image/cc.png").getImage();
        person = new Person();
        source = new ImageIcon("image/a12.png").getImage();
        HP = new ImageIcon("image/a12.png").getImage();
        pet = new Pet();
//        gold = new Gold();
//        missile = new Missile();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //1.绘制背景图
        //第一张图
        g.drawImage(image, imageX, 0, 1000, 550, null);
        //第二张图
        g.drawImage(image, imageX + 1000, 0, 1000, 550, null);

        //2.绘制人物
        person.paintPerson(g);

        //3.绘制分数
        g.drawImage(source, 100, 60, 160, 40, null);
        g.setColor(Color.orange);//设置颜色
        g.setFont(new Font("宋体", Font.BOLD, 16));//设置字体
        g.drawString("分数：" + person.score + "分", 150, 85);

        //4.绘制血量
        g.drawImage(HP, 300, 60, 160, 40, null);
        g.setColor(Color.orange);
        g.setFont(new Font("宋体", Font.BOLD, 16));
        g.drawString("HP:" + person.hp, 350, 85);

        //5.绘制宠物
        pet.paintPet(g);

        //6.绘制金币
//        gold.paintGole(g);
        for (int i = 0; i < golds.size(); i++) {
            golds.get(i).paintGole(g);
        }

        //7.绘制导弹
//        missile.paintMissile(g);
        for (int i = 0; i < missiles.size(); i++) {
            missiles.get(i).paintMissile(g);
        }
    }

    public void action() {
        new Thread() {
            public void run() {
                while (true) {//死循环
                    imageX--;
                    if (imageX + 1000 == 0) {//初始化
                        imageX = 0;
                    }
                    repaint();//不断绘制
                    creatGold();//调用金币生成的方法
                    creatMissile();//调用导弹生成的方法
                    person.drop();//人物自由下落
                    pet.drop();//宠物自由下落
                    collision();//碰撞方法
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /**
     * 生成金币的方法
     */
    public void creatGold() {
        goldIndex++;
        if (goldIndex == 100) {//控制金币生成的效率  1s生成一个金币
            goldIndex = 0;
            Gold gold = new Gold();
            golds.add(gold);
        }
    }
    /**
     * 生成导弹的方法
     */
    public void creatMissile() {
        missileIndex++;
        if (missileIndex == 300) {//控制导弹生成的效率   3s生成一个导弹
            missileIndex = 0;
            Missile missile = new Missile();
            missiles.add(missile);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("按下键盘");
        if (e.getKeyCode() == KeyEvent.VK_W) {//向上移动
            //人物
            person.y = person.y - 100;
            if (person.y <= 0) {
                person.y = 0;
            }

            //宠物
            pet.y = pet.y - 100;
            if (pet.y <= 0) {
                pet.y = 0;
            }

        } else if (e.getKeyCode() == KeyEvent.VK_A) {//向左移动
            //人物
            person.x = person.x - 20;
            if (person.x <= 0) {
                person.x = 0;
            }

            //宠物
            pet.x = pet.x - 20;
            if (pet.x <= 70) {
                pet.x = 70;
            }

        } else if (e.getKeyCode() == KeyEvent.VK_D) {//向右移动
            //人物
            person.x = person.x + 20;
            if (person.x >= 880) {
                person.x = 880;
            }

            //宠物
            pet.x = pet.x + 20;
            if (pet.x >= 950) {
                pet.x = 950;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("抬起键盘");
    }

    /**
     * 碰撞方法
     */
    public void collision() {
        //金币碰撞
        for (int i = 0; i < golds.size(); i++) {
            //金币的碰撞
            Gold gold = golds.get(i);//从金币的集合中取出一枚金币
            if (person.x + person.width >= gold.x
                    && person.x <= gold.x + gold.width
                    && person.y <= gold.y + gold.height
                    && person.y + person.height >= gold.y) {
                golds.remove(gold);
                person.score++;
            }
        }

        //导弹碰撞
        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);//从导弹的集合中取出一枚导弹
            if (person.x + person.width >= missile.x
                    && person.x <= missile.x + missile.width
                    && person.y <= missile.y + missile.height
                    && person.y + person.height >= missile.y) {
                missiles.remove(missile);//移除导弹
                person.hp -= 20;
                if (person.hp <= 0) {//hp为0时，退出游戏
                    System.exit(0);//退出游戏
                }
            }
        }
    }
}
