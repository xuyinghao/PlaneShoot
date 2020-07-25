package shoot.object.hero;

import javafx.scene.image.Image;
import shoot.ShootGame;
import shoot.object.father.FlyingObject;
import util.Tool;

/**
 * 英雄机
 */
public class HeroPlane extends FlyingObject {
    private static Image[] images;//图片数组
    private int life = 3;
    private int bulletCount;//子弹数
    private int fire = 2;//火力（默认为2）

    static {
        images = new Image[2];
        images[0] = Tool.readImg("own1.png");
        images[1] = Tool.readImg("ownbz.png");
    }

    public HeroPlane() {
        super(images[0], ShootGame.WIDTH / 2, ShootGame.HEIGHT / 4 * 3);
    }

    //加命
    public void addLife() {
        life++;
    }

    //减命
    public void subLife() {
        life--;
    }

    //获取命
    public int getLife() {
        return life;
    }

    //加火力
    public void addFire() {
        fire++;
    }

    //清空火力
    public void ClearFire() {
        fire = 0;
    }

    //发射子弹
    public HeroBullet[] shootBullet() {
        if (fire >= 3) {
            bulletCount = 3;
        } else if (fire == 2) {
            bulletCount = 2;
        } else {
            bulletCount = 1;
        }
        //根据英雄机的位置确定子弹
        HeroBullet[] hbs = new HeroBullet[bulletCount];
        int yStep = (int) (this.image.getHeight() / 2);
        int xStep = (int) (this.image.getWidth() / (bulletCount + 1));
        for (int i = 0; i < hbs.length; i++) {
            hbs[i] = new HeroBullet(this.x - ((int) this.image.getWidth() / 2) + (i + 1) * xStep, this.y - yStep);
        }
        return hbs;
    }

    //移动
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //设置图片
    public void setImage() {
        setImage(images);
    }

    int index = 0;

    public void changeImage() {
        setImage(images[1]);
    }

    @Override
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
}
