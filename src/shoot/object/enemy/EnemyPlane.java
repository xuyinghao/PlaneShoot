package shoot.object.enemy;

import javafx.scene.image.Image;

/**
 * 敌机
 */
public abstract class EnemyPlane extends Enemy {
    protected int life;
    protected int bulletCount;

    public EnemyPlane(Image image) {
        super(image);
    }

    //减命
    public void subLife() {
        life--;
    }

    public int getLife() {
        return life;
    }

    public EnemyBullet[] shootBullet() {
        //根据英雄机的位置确定子弹
        EnemyBullet[] ebs = new EnemyBullet[bulletCount];
        int yStep = (int) (this.image.getHeight() / 2);
        int xStep = (int) (this.image.getWidth() / (bulletCount + 1));
        for (int i = 0; i < ebs.length; i++) {
            ebs[i] = new EnemyBullet(this.x - ((int) this.image.getWidth() / 2) + (i + 1) * xStep, this.y + yStep);
        }
        return ebs;
    }
}

