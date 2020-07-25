package shoot.object.father;

import javafx.scene.image.Image;
import shoot.ShootGame;

import java.util.Random;

/**
 * 飞行物基类
 */
public abstract class FlyingObject {
    public static final int ALIVE = 0;//活着
    public static final int DEAD = 1;//死亡
    public static final int DELETABLE = 2;//可删除
    public int state = ALIVE;//状态
    public Image image;
    public int x;
    public int y;

    //英雄机或子弹构造
    public FlyingObject(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    //敌机构造
    public FlyingObject(Image image) {
        this.image = image;
        int w1 = ShootGame.WIDTH;//屏幕宽
        int w2 = (int) this.image.getWidth();
        int h2 = (int) this.image.getHeight();
        Random random = new Random();
        this.x = random.nextInt(w1 - w2);
        this.y = h2 / 2;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    int index = 1;
    public void setImage(Image[] images) {
        if (state == ALIVE) {
            image = images[0];
        } else if (state == DEAD) {
            image = images[index];
            index++;
            if (index == images.length) {
                state = DELETABLE;
            }
        } else {
            image = null;
        }
    }

    public abstract void setImage();
}
