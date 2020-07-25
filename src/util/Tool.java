package util;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * 工具类
 */
public class Tool {
    //获取图片
    public static Image readImg(String name) {
        return new Image(Tool.class.getResourceAsStream("/img/"+name));
    }
    //获取Mp3
    public static MediaPlayer readMp3(String name)
    {
        return new MediaPlayer(new Media(Tool.class.getResource("/mp3/"+name).toString()));
    }
}
