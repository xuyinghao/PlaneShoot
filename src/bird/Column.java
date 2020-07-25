package bird;

import javafx.scene.image.Image;
import util.Tool;

import java.util.Random;

/**
 * 柱子类
 */
public class Column {
    Image image = Tool.readImg("column.png");
    int x;
    int y;
    int width;
    int height;
    Random random = new Random();

    public Column(int i) {
        width = (int) image.getWidth() / 2;
        height = (int) image.getHeight() / 2;
        x = 300 + (i - 1) * 256;
        y = -random.nextInt(height + 120 - FlyBird.HEIGHT + 1);
    }

    public void move() {
        if (x <= -width) {
            x = 300+256;
            y = -random.nextInt(height + 120 - FlyBird.HEIGHT + 1);
        }
        x--;
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
}
