package shoot.object.hero;

import javafx.scene.image.Image;
import shoot.object.father.FlyingObject;
import util.Tool;

/**
 * 英雄子弹
 */
public class HeroBullet extends FlyingObject {
    private static Image[] images;
    private int ySpeed = -3;//y方向的速度

    static {
        images = new Image[2];
        images[0] = Tool.readImg("fire2.png");
        images[1] = Tool.readImg("fire2.png");
    }

    public HeroBullet(int x, int y) {
        super(images[0], x, y);
    }

    public void move() {
        y += ySpeed;
    }

    //越界
    public boolean overflow() {
        if (this.y <= -this.image.getHeight() / 2) {
            return true;
        }
        return false;
    }

    //设置图片
    public void setImage() {
        setImage(images);
    }
}
