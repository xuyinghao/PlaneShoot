package bird;

import javafx.scene.image.Image;
import util.Tool;

/**
 * 地面
 */
public class Ground {
    int x;
    int y;
    int width;
    int height;

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    Image image = Tool.readImg("ground.png");

    public Ground() {
        width = (int) image.getWidth();
        height = (int) image.getHeight()/3;
        this.x = 0;
        this.y = FlyBird.HEIGHT - height;
    }

    public void move() {
        if (x <= -(width - FlyBird.WIDTH)) {
            x = 0;
        }
        x--;
    }
}
