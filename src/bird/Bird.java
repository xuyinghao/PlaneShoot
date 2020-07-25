package bird;

import javafx.scene.image.Image;
import util.Tool;

/**
 * 小鸟
 */
public class Bird {
    static Image[] images;

    static {
        images = new Image[8];
        for (int i = 0; i < images.length; i++) {
            images[i] = Tool.readImg(  i + ".png");
        }
    }

    Image image = images[0];
    int x = 100;
    double y = 200;
    //初速度
    double v0 = 5;
    //时间
    double t = 0.15;
    //距离
    double s = 0;
    //重力
    int g = 2;
    int index = 0;


    public void fly() {
        if (index == images.length) {
            index = 0;
        }
        image = images[index];
        index++;
    }

    public void move() {
        s = v0 * t;
        y = y - s;
        double v2 = v0 - g * t;
        v0 = v2;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean overFlow(Ground ground) {
        if (y <= 0 || y >= FlyBird.HEIGHT - ground.getHeight()) {
            return true;
        }
        return false;
    }

    public boolean hit(Column column) {
        if (x >= column.x - 25 && x <= column.x + column.width) {
            if(y>column.height/2+column.y-75/2-5&&y<column.height/2+column.y+75/2-20){
                return false;
            }
            return true;
        }
        return false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
