package shoot.object.enemy;

import javafx.scene.image.Image;
import shoot.dao.Award;
import shoot.dao.Score;
import util.Tool;

import java.util.Random;

/**
 * 轰炸机
 */
public class BossPlane extends EnemyPlane implements Award, Score {
    private static Image[] images;
    private int score = 50;//分数
    private int award = new Random().nextInt(2);
    private int xSpeed = (int) Math.pow(-1, new Random().nextInt(2)) * 1;

    static {
        images = new Image[2];
        images[0] = Tool.readImg("ep09.png");
        images[1] = Tool.readImg("sj.png");
    }

    public BossPlane() {
        super(images[0]);
        life = 5;
        bulletCount = 5;
        ySpeed = 2;
    }

    public void setImage() {
        setImage(images);
    }

    @Override
    public void move() {
        if (this.y < this.image.getHeight() / 2) {
            y += ySpeed;
        } else {
            x += xSpeed;
        }
    }

    @Override
    public int getAward() {
        return award;
    }

    @Override
    public int getScore() {
        return score;
    }
}
