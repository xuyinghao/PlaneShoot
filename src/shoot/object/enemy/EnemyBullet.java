package shoot.object.enemy;

import javafx.scene.image.Image;
import util.Tool;

/**
 * 敌人子弹
 */
public class EnemyBullet extends Enemy {
    private static Image[] images;

    static {
        images = new Image[2];
        images[0] = Tool.readImg("fire1.png");
        images[1] = Tool.readImg("fire1.png");
    }

    public EnemyBullet(int x, int y) {
        super(images[0], x, y);
        ySpeed = 3;
    }

    //设置图片
    public void setImage() {
        setImage(images);
    }
}
