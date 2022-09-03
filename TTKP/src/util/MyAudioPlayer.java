package util;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 播放背景音乐
 */
public class MyAudioPlayer {

    private AudioStream audioStream = null; // 播放器

    public MyAudioPlayer(String musicSrc) {
        try {
            InputStream inputStream = new FileInputStream(musicSrc); // 获得音乐文件的输入流
            audioStream = new AudioStream(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用AudioPlayer静态成员player.start播放音乐
     */
    public void play() {
        AudioPlayer.player.start(audioStream);
    }

}

