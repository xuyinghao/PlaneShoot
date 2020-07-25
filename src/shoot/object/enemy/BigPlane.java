package shoot.object.enemy;

import javafx.scene.image.Image;
import shoot.dao.Award;
import util.Tool;

import java.util.Random;

/**
 * 大敌机
 */
public class BigPlane extends EnemyPlane implements Award {
    private static Image[] images;
    private int award = new Random().nextInt(2);

    static {
        images = new Image[2];
        images[0] = Tool.readImg("ep05.png");
        images[1] = Tool.readImg("dfjbz.png");
    }

    public BigPlane() {
        super(images[0]);
        life = 2;
        bulletCount = 2;
        ySpeed = 2;
    }

    public void setImage() {
        setImage(images);
    }

    @Override
    public int getAward() {
        return award;
    }
}
