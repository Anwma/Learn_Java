package util;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Mic extends Thread {
    public Mic(String musicSrc) {
        //使用线程完成音频的播放
        new Thread("musicSrc") {
            public void run() {
                String filename = musicSrc;
                try {
                    BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
                    Player player = new Player(buffer);
                    player.play();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
    }
}
