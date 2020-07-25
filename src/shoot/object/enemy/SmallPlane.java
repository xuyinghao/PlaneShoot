package shoot.object.enemy;

import javafx.scene.image.Image;
import shoot.dao.Score;
import util.Tool;


/**
 * 小敌机
 */
public class SmallPlane extends EnemyPlane implements Score {
    private static Image[] images;
    private int score = 10;//分数

    static {
        images = new Image[2];
        images[0]=Tool.readImg("ep00.png");
        images[1]=Tool.readImg("xzfjbz.png");
    }

    public SmallPlane() {
        super(images[0]);
        life = 1;
        bulletCount = 1;
        ySpeed = 1;
    }
    public void setImage() {
        setImage(images);
    }

    @Override
    public int getScore() {
        return score;
    }
}
