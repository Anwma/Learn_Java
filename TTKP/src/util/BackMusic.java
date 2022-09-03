package util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

/**
 * 播放背景音乐
 */
public class BackMusic {

    public BackMusic(String musicSrc){

        File file = new File(musicSrc);

        try {//使用toURL转化为Url类型
            AudioClip audioClip = Applet.newAudioClip(file.toURL());

            //循环播放播放音频
            audioClip.loop();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
